package com.backdevanderson.studiojoice.config;


import com.backdevanderson.studiojoice.entity.Agendamento;
import com.backdevanderson.studiojoice.entity.Cliente;
import com.backdevanderson.studiojoice.entity.Profissional;
import com.backdevanderson.studiojoice.entity.Servico;
import com.backdevanderson.studiojoice.repository.AgendamentoRepository;
import com.backdevanderson.studiojoice.repository.ClienteRepository;
import com.backdevanderson.studiojoice.repository.ProfissionalRepository;
import com.backdevanderson.studiojoice.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Override
    public void run(String... args) throws Exception {

        // 👩‍🔧 PROFISSIONAIS
        Profissional p1 = Profissional.builder()
                .nome("Joice")
                .especialidade("Extensão de Cílios")
                .build();

        Profissional p2 = Profissional.builder()
                .nome("Sula")
                .especialidade("Design de Sobrancelha")
                .build();

        profissionalRepository.saveAll(Arrays.asList(p1, p2));

        // 👤 CLIENTES
        Cliente c1 = Cliente.builder()
                .nome("Anderson Costa")
                .cpf("47233289808")
                .email("anderson@gmail.com")
                .telefone("19999407060")
                .build();

        Cliente c2 = Cliente.builder()
                .nome("Joice Mileni")
                .cpf("50063420805")
                .email("joice@gmail.com")
                .telefone("19111111111")
                .build();

        clienteRepository.saveAll(Arrays.asList(c1, c2));

        // 💅 SERVIÇOS
        Servico s1 = Servico.builder()
                .nome("Extensão de Cílios")
                .preco(150.0)
                .tempoDuracao(60)
                .build();

        Servico s2 = Servico.builder()
                .nome("Design de Sobrancelha")
                .preco(60.0)
                .tempoDuracao(30)
                .build();

        servicoRepository.saveAll(Arrays.asList(s1, s2));

        // 📅 AGENDAMENTOS
        Agendamento a1 = Agendamento.builder()
                .dataHora(LocalDateTime.of(2025, 11, 7, 14, 0))
                .cliente(c1)
                .profissional(p1)
                .servico(s1)
                .build();

        Agendamento a2 = Agendamento.builder()
                .dataHora(LocalDateTime.of(2025, 11, 7, 15, 0))
                .cliente(c2)
                .profissional(p2)
                .servico(s2)
                .build();

        agendamentoRepository.saveAll(Arrays.asList(a1, a2));

        System.out.println("✅ Dados de teste inseridos com sucesso no banco H2!");
    }
}
