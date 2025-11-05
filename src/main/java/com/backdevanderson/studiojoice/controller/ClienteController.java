package com.backdevanderson.studiojoice.controller;


import com.backdevanderson.studiojoice.entity.Cliente;
import com.backdevanderson.studiojoice.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAall(){
        List<Cliente> list = clienteService.buscarTodosClientes();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(clienteService.buscarPorId(id));
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<Cliente> findByCpf(@PathVariable String cpf){
        return ResponseEntity.ok().body(clienteService.buscarPorCpf(cpf));
    }

    @GetMapping(value = "/telefone/{telefone}")
    public ResponseEntity<Cliente> findByTelefone(@PathVariable String telefone){
        return ResponseEntity.ok().body(clienteService.buscarPorTelefone(telefone));
    }

    @PostMapping
    public ResponseEntity<Cliente> insertCliente(@RequestBody Cliente cliente){
        clienteService.criarCliente(cliente);
        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{cpf}")
    public ResponseEntity<Void> deletarClienteCpf(@PathVariable String cpf){
        clienteService.deletarClienteCpf(cpf);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        cliente = clienteService.atualizarCliente(id, cliente);
        return ResponseEntity.ok().body(cliente);
    }


}
