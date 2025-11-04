package com.backdevanderson.studiojoice.service;


import com.backdevanderson.studiojoice.entity.Cliente;
import com.backdevanderson.studiojoice.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;


    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarTodosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).
                orElseThrow(() -> new RuntimeException("id não encontrado"));
    }

    public Cliente buscarPorCpf(String cpf){
        return clienteRepository.findByCpf(cpf).
                orElseThrow(()-> new RuntimeException("Cpf não encontrado"));
    }

    public Cliente buscarPorTelefone(String telefone){
        return clienteRepository.findByTelefone(telefone).
                orElseThrow(()->new RuntimeException("telefone não encontrado"));
    }

    public void deletarCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public void deletarClienteCpf(String cpf){
        Cliente cliente = clienteRepository.findByCpf(cpf).
                orElseThrow(()-> new RuntimeException("Cliente não encontrado"));

        clienteRepository.delete(cliente);
    }

    public Cliente atualizarCliente(Long id, Cliente cliente){
        Cliente novo = clienteRepository.getReferenceById(id);

        novo.setNome(cliente.getNome());
        novo.setCpf(cliente.getCpf());
        novo.setEmail(cliente.getEmail());
        novo.setTelefone(cliente.getTelefone());

        return clienteRepository.save(novo);
    }
}
