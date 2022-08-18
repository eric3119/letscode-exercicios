package com.bbletscode.rotativo.services;

import com.bbletscode.rotativo.dto.RotativoDTO;
import com.bbletscode.rotativo.dto.RotativoSaidaDTO;
import com.bbletscode.rotativo.exceptions.ValidacaoException;
import com.bbletscode.rotativo.models.Cliente;
import com.bbletscode.rotativo.models.Rotativo;
import com.bbletscode.rotativo.models.Veiculo;
import com.bbletscode.rotativo.repositories.RotativoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotativoService {
    @Autowired
    private RotativoRepository rotativoRepository;
    @Autowired
    private VeiculoService veiculoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ModelMapper modelMapper;

    @Cacheable(value = "rotativos")
    public List<Rotativo> findAll(Boolean estacionados) {
        List<Rotativo> result;
        if (estacionados != null) {
            if (estacionados)
                result = rotativoRepository.findBySaidaIsNull();
            else
                result = rotativoRepository.findBySaidaIsNotNull();
        } else {
            result = rotativoRepository.findAll();
        }

        return result;
    }

    @CacheEvict(value = "rotativos", allEntries = true)
    public Rotativo salvar(RotativoDTO rotativoDTO) {
        Veiculo veiculoSalvo = veiculoService.findById(rotativoDTO.getId_veiculo());
        Rotativo estacionado = rotativoRepository.findByVeiculoAndSaidaIsNull(veiculoSalvo);
        if(estacionado != null) throw new ValidacaoException("Veículo já está estacionado");

        return persistir(rotativoDTO);
    }

    public Rotativo saida(RotativoSaidaDTO rotativoSaidaDTO) {
        Rotativo entity = rotativoRepository.findById(rotativoSaidaDTO.getId()).orElseThrow(
                () -> new ValidacaoException("Não encontrado")
        );
        if(entity.getSaida() != null) throw new ValidacaoException("Saída já registrada");

        RotativoDTO rotativoDTO = modelMapper.map(entity, RotativoDTO.class);
        rotativoDTO.setId_cliente(entity.getCliente().getId());
        rotativoDTO.setId_veiculo(entity.getVeiculo().getId());

        modelMapper.map(rotativoSaidaDTO, rotativoDTO);

        return persistir(rotativoDTO);
    }

    private Rotativo persistir(RotativoDTO rotativoDTO) {
        Rotativo rotativo = modelMapper.map(rotativoDTO, Rotativo.class);

        Veiculo veiculoSalvo = veiculoService.findById(rotativoDTO.getId_veiculo());
        Cliente clienteSalvo = clienteService.findById(rotativoDTO.getId_cliente());

        rotativo.setVeiculo(veiculoSalvo);
        rotativo.setCliente(clienteSalvo);

        return rotativoRepository.save(rotativo);
    }
}