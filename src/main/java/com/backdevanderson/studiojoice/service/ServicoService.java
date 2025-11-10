package com.backdevanderson.studiojoice.service;


import com.backdevanderson.studiojoice.entity.Servico;
import com.backdevanderson.studiojoice.exceptions.ResourceNotFound;
import com.backdevanderson.studiojoice.repository.ServicoRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServicoService {


    private ServicoRepository servicoRepository;

    public Servico criarServico(Servico servico){
        return servicoRepository.save(servico);
    }

    public List<Servico> buscarTodosServico(){
        return servicoRepository.findAll();
    }

    public Servico buscarPorId(Long id){
        return servicoRepository.findById(id).
                orElseThrow(()-> new ResourceNotFound("Serviço não encontrado: " + id));
    }

    public void deletarServico(Long id){
        servicoRepository.deleteById(id);
    }

    public Servico atualizarServico(Long id, Servico servico){
        Servico novo = servicoRepository.getReferenceById(id);
        novo.setNome(servico.getNome());
        novo.setPreco(servico.getPreco());
        novo.setTempoDuracao(servico.getTempoDuracao());

        return servicoRepository.save(novo);
    }


}
