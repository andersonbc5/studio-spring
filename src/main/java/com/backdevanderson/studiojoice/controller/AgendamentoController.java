package com.backdevanderson.studiojoice.controller;


import com.backdevanderson.studiojoice.entity.Agendamento;
import com.backdevanderson.studiojoice.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping
    public ResponseEntity<List<Agendamento>> listarTodos() {
        List<Agendamento> lista = agendamentoService.buscarTodosAgendamentos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Agendamento> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(agendamentoService.buscarPorId(id));
    }

    // Listar agendamentos entre duas datas
    @GetMapping("/por-data")
    public ResponseEntity<List<Agendamento>> listarPorData(
            @RequestParam LocalDateTime inicio,
            @RequestParam LocalDateTime fim) {
        List<Agendamento> lista = agendamentoService.listarPorDataHora(inicio, fim);
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<Agendamento> insertAgendamento(@RequestBody Agendamento agendamento){
        agendamentoService.criarAgendamento(agendamento);
        return ResponseEntity.ok().body(agendamento);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        agendamentoService.deletarAgendamento(id);
        return ResponseEntity.noContent().build();
    }

}
