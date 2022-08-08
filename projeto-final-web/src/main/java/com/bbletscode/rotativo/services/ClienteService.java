package com.bbletscode.rotativo.services;

import com.bbletscode.rotativo.models.Cliente;
import com.bbletscode.rotativo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
