package com.backdevanderson.studiojoice.controller;


import com.backdevanderson.studiojoice.entity.Servico;
import com.backdevanderson.studiojoice.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<Servico>> findAll(){
        List<Servico> list = servicoService.buscarTodosServico();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(servicoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Servico> insertCliente(@RequestBody Servico servico){
        servicoService.criarServico(servico);
        return ResponseEntity.ok().body(servico);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Servico> updateServico(@PathVariable Long id, @RequestBody Servico servico){
        servico = servicoService.atualizarServico(id, servico);
        return ResponseEntity.ok().body(servico);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        servicoService.deletarServico(id);
        return ResponseEntity.noContent().build();
    }
}
