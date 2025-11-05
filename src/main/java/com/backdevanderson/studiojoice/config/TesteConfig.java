package com.backdevanderson.studiojoice.config;


import com.backdevanderson.studiojoice.entity.Cliente;
import com.backdevanderson.studiojoice.entity.Profissional;
import com.backdevanderson.studiojoice.repository.ClienteRepository;
import com.backdevanderson.studiojoice.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("teste")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;


    @Override
    public void run(String... args) throws Exception {


        Profissional p1 = new Profissional(null, "Joice", "Extensão de Cilios");
        Profissional p2 = new Profissional(null, "Sula", "Design Sobrancelha");
        profissionalRepository.saveAll(Arrays.asList(p1,p2));

        Cliente c1 = new Cliente(null, "Anderson Costa",
                "47233289808", "anderson@gmail.com", "19999407060");

        Cliente c2 = new Cliente(null, "Joice Mileni",
                "50063420805", "joice@gmail.com", "19111111111");
        clienteRepository.saveAll(Arrays.asList(c1,c2));

    }
}
