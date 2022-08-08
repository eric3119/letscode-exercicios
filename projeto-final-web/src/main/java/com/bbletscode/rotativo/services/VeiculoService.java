package com.bbletscode.rotativo.services;

import com.bbletscode.rotativo.models.Veiculo;
import com.bbletscode.rotativo.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
