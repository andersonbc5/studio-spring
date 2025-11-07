package com.backdevanderson.studiojoice.service;


import com.backdevanderson.studiojoice.entity.Agendamento;
import com.backdevanderson.studiojoice.repository.AgendamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AgendamentoService {

    private AgendamentoRepository agendamentoRepository;


    public List<Agendamento> buscarTodosAgendamentos(){
        return agendamentoRepository.findAll();
    }

    public Agendamento buscarPorId(Long id){
        return agendamentoRepository.findById(id).
                orElseThrow(()->new RuntimeException("Agendamento não encontrado"));
    }

    public Agendamento criarAgendamento(Agendamento agendamento){

        boolean ocupado = agendamentoRepository.existsByProfissionalIdAndDataHora(agendamento.getProfissional()
                .getId(), agendamento.getDataHora());

        if (ocupado){
            throw new RuntimeException("Este horário já está ocupado para a profissional selecionada");
        }

        return agendamentoRepository.save(agendamento);
    }

    public void deletarAgendamento(Long id){
        agendamentoRepository.deleteById(id);
    }

    public List<Agendamento> listarPorDataHora(LocalDateTime inicio, LocalDateTime fim){
        return agendamentoRepository.findByDataHoraBetween(inicio, fim);
    }
}
