package com.bbletscode.rotativo.services;

import com.bbletscode.rotativo.models.Rotativo;
import com.bbletscode.rotativo.repositories.RotativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotativoService implements IRotativoService {

    @Autowired
    private RotativoRepository rotativoRepository;

    public List<Rotativo> findAll(){
        return rotativoRepository.findAll();
    }
    public Rotativo salvar(Rotativo rotativo) {
        System.out.println(rotativo);
        return rotativoRepository.save(rotativo);
    }

}