package com.bbletscode.rotativo.services;

import com.bbletscode.rotativo.exceptions.ValidacaoException;
import com.bbletscode.rotativo.models.Veiculo;
import com.bbletscode.rotativo.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> findAll(){
        return veiculoRepository.findAll();
    }

    public Veiculo salvar(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

    public Veiculo findById(long id_veiculo) {
        return veiculoRepository.findById(id_veiculo).orElseThrow(() -> new ValidacaoException("id_veiculo não encontrado"));
    }
}
