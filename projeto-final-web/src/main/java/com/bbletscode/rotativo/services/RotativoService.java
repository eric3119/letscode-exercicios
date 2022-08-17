package com.bbletscode.rotativo.services;

import com.bbletscode.rotativo.dto.RotativoDTO;
import com.bbletscode.rotativo.models.Cliente;
import com.bbletscode.rotativo.models.Rotativo;
import com.bbletscode.rotativo.models.Veiculo;
import com.bbletscode.rotativo.repositories.RotativoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotativoService implements IRotativoService {
    @Autowired
    private RotativoRepository rotativoRepository;
    @Autowired
    private VeiculoService veiculoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ModelMapper modelMapper;


    public List<Rotativo> findAll(){
        return rotativoRepository.findAll();
    }
    public Rotativo salvar(RotativoDTO rotativoDTO) {
        Rotativo rotativo = modelMapper.map(rotativoDTO, Rotativo.class);

        Veiculo veiculoSalvo = veiculoService.findById(rotativoDTO.getId_veiculo());
        Cliente clienteSalvo = clienteService.findById(rotativoDTO.getId_cliente());

        rotativo.setVeiculo(veiculoSalvo);
        rotativo.setCliente(clienteSalvo);

        return rotativoRepository.save(rotativo);
    }

}