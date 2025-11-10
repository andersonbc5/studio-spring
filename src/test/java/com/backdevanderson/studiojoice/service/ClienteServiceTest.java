package com.backdevanderson.studiojoice.service;

import com.backdevanderson.studiojoice.entity.Cliente;
import com.backdevanderson.studiojoice.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    ClienteRepository clienteRepository;

    @InjectMocks
    ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarTodosClientes() {
        //arrange
        Cliente cliente = new Cliente(1L, "Anderson",
                "47233289808", "anderson@gmail.com", "19999407960", null);

        List<Cliente> listaEsperada = new ArrayList<>();
        listaEsperada.add(cliente);
        when(clienteRepository.findAll()).thenReturn(listaEsperada);

        //act
        List<Cliente> resultado = clienteService.buscarTodosClientes();

        //assert
        assertNotNull(resultado);

        assertEquals("47233289808", resultado.get(0).getCpf());
    }

    @Test
    void deveRetornarUmClientePorId(){

        //arrange
        Cliente cliente = new Cliente(3L, "Anderson",
                "47233289808", "anderson@gmail.com", "19999407960", null);

        when(clienteRepository.findById(3L)).thenReturn(Optional.of(cliente));

        //act
        Cliente clienteEncontrado = clienteService.buscarPorId(3L);

        //assert
        assertNotNull(clienteEncontrado);
        assertEquals(3L, clienteEncontrado.getId());
    }

    @Test
    void deverRetornarUmClientePorCpf(){
        //arrange
        Cliente cliente = new Cliente(3L, "Anderson",
                "47233289808", "anderson@gmail.com", "19999407960", null);

        when(clienteRepository.findByCpf("47233289808")).thenReturn(Optional.of(cliente));

        //act
        Cliente clienteEncontrado = clienteService.buscarPorCpf("47233289808");

        assertNotNull(clienteEncontrado);
        assertEquals("47233289808", clienteEncontrado.getCpf());
        assertEquals("Anderson", clienteEncontrado.getNome());
    }
}