package com.backdevanderson.studiojoice.controller;


import com.backdevanderson.studiojoice.entity.Profissional;
import com.backdevanderson.studiojoice.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profissional")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @GetMapping
    public ResponseEntity<List<Profissional>> findAll(){
        List<Profissional> list = profissionalService.buscarTodasProfissionais();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Profissional> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(profissionalService.buscarPorId(id));
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<Profissional> findByNome(@PathVariable String nome){
        return ResponseEntity.ok().body(profissionalService.buscarPorNome(nome));
    }

    @GetMapping(value = "/especialidade/{especialidade}")
    public ResponseEntity<Profissional> findByEspecialidade(@PathVariable String especialidade){
        return ResponseEntity.ok().body(profissionalService.buscarPorEspecialidade(especialidade));
    }

    @PostMapping
    public ResponseEntity<Profissional> insertProfissional(@RequestBody Profissional profissional){
        profissionalService.criarProfissional(profissional);
        return ResponseEntity.ok().body(profissional);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProfissional(@PathVariable Long id){
        profissionalService.deletarProfissional(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Profissional> updateProfissional(@PathVariable Long id, Profissional profissional){
        profissional = profissionalService.atualizarProfissional(id, profissional);
        return ResponseEntity.ok().body(profissional);
    }
}
