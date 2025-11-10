package com.backdevanderson.studiojoice.service;

import com.backdevanderson.studiojoice.entity.Profissional;
import com.backdevanderson.studiojoice.repository.ProfissionalRepository;
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
class ProfissionalServiceTest {

    @Mock
    ProfissionalRepository profissionalRepository;

    @InjectMocks
    ProfissionalService profissionalService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void buscarTodasProfissionais() {

        Profissional p1 = new Profissional(null, "Joice", "Extensão de Cilios", null);
        Profissional p2 = new Profissional(null, "Sula", "Design Sobrancelha", null);

        List<Profissional> listaEsperada = new ArrayList<>();
        listaEsperada.add(p1);
        listaEsperada.add(p2);

        when(profissionalRepository.findAll()).thenReturn(listaEsperada);

        List<Profissional> resultado = profissionalService.buscarTodasProfissionais();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Joice", resultado.get(0).getNome());
        assertEquals("Sula", resultado.get(1).getNome());


    }
}