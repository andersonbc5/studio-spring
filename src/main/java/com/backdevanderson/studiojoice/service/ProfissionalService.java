package com.backdevanderson.studiojoice.service;


import com.backdevanderson.studiojoice.entity.Profissional;
import com.backdevanderson.studiojoice.exceptions.ResourceNotFound;
import com.backdevanderson.studiojoice.repository.ProfissionalRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfissionalService {


    private ProfissionalRepository profissionalRepository;

    public Profissional criarProfissional(Profissional profissional){
        return profissionalRepository.save(profissional);
    }

    public List<Profissional> buscarTodasProfissionais(){
        return profissionalRepository.findAll();
    }

    public Profissional buscarPorNome(String nome){
        return profissionalRepository.findByNome(nome).
                orElseThrow(()->new ResourceNotFound("Profissional não encontrada: " + nome));
    }

    public Profissional buscarPorEspecialidade(String especialidade){
        return profissionalRepository.findByEspecialidade(especialidade).
                orElseThrow(()->new ResourceNotFound("Especialidade não encontrada: " + especialidade));
    }

    public Profissional buscarPorId(Long id){
        return profissionalRepository.findById(id).
                orElseThrow(()->new ResourceNotFound("Profissional não encontrada: id " + id));
    }

    public void deletarProfissional(Long id){
        profissionalRepository.deleteById(id);
    }

    public Profissional atualizarProfissional(Long id, Profissional profissional){
        Profissional novo = profissionalRepository.getReferenceById(id);

        novo.setNome(profissional.getNome());
        novo.setEspecialidade(profissional.getEspecialidade());

        return profissionalRepository.save(novo);
    }
}
