package com.bbletscode.rotativo.services;

import com.bbletscode.rotativo.exceptions.ValidacaoException;
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
        clienteRepository.findByNome(cliente.getNome()).stream().findAny().ifPresent(
                (c) -> {
                    throw new ValidacaoException("Cliente já cadastrado");
                }
        );
        return clienteRepository.save(cliente);
    }

    public Cliente findById(long id_cliente) {
        return clienteRepository.findById(id_cliente).orElseThrow(() -> new ValidacaoException("id_cliente não encontrado"));
    }
}
