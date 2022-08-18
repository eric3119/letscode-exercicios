package com.bbletscode.rotativo.controllers;

import com.bbletscode.rotativo.dto.RotativoDTO;
import com.bbletscode.rotativo.dto.RotativoSaidaDTO;
import com.bbletscode.rotativo.models.Rotativo;
import com.bbletscode.rotativo.services.RotativoService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/rotativos")
public class RotativoController {

    @Autowired
    private RotativoService rotativoService;

    @Operation(description = "Lista veículos (filtrar por estacionado)")
    @GetMapping
    public ResponseEntity<List<Rotativo>> findAll(@RequestParam(required = false) Boolean estacionados){
        return ResponseEntity.ok(rotativoService.findAll(estacionados));
    }

    @Operation(description = "Registra entrada de veículo")
    @PostMapping
    public ResponseEntity<Rotativo> salvar(@RequestBody @Valid RotativoDTO rotativoDTO){
        return ResponseEntity.ok(rotativoService.salvar(rotativoDTO));
    }

    @Operation(description = "Registra saída de veículo")
    @PatchMapping
    public ResponseEntity<Rotativo> atualizar(@RequestBody @Valid RotativoSaidaDTO rotativoSaidaDTO){
        return ResponseEntity.ok(rotativoService.saida(rotativoSaidaDTO));
    }
}
