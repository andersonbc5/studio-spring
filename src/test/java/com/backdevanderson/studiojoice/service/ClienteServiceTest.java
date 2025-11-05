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

        Cliente cliente = new Cliente(1L, "Anderson",
                "47233289808", "anderson@gmail.com", "19999407960");

        List<Cliente> listaEsperada = new ArrayList<>();
        listaEsperada.add(cliente);
        when(clienteRepository.findAll()).thenReturn(listaEsperada);

        List<Cliente> resultado = clienteService.buscarTodosClientes();

        assertNotNull(resultado);

        assertEquals("47233289808", resultado.get(0).getCpf());

    }
}