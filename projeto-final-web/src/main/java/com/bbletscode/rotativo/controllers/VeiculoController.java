package com.bbletscode.rotativo.controllers;

import com.bbletscode.rotativo.models.Veiculo;
import com.bbletscode.rotativo.services.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @Operation(description = "Listar veículos cadastrados")
    @GetMapping
    public ResponseEntity<List<Veiculo>> findAll() {
        return ResponseEntity.ok(veiculoService.findAll());
    }

    @Operation(description = "Cadastrar um veículo")
    @PostMapping
    public ResponseEntity<Veiculo> salvar(@RequestBody @Valid Veiculo veiculo) {
        return ResponseEntity.ok(veiculoService.salvar(veiculo));
    }
}
