package com.bbletscode.rotativo.controllers;

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
@RequestMapping("/rotativos")
public class RotativoController {

    @Autowired
    private RotativoService rotativoService;

    @Operation(description = "Listar veículos estacionados")
    @GetMapping
    public ResponseEntity<List<Rotativo>> findAll(){
        return ResponseEntity.ok(rotativoService.findAll());
    }

    @Operation(description = "Registrar entrada de veículo")
    @PostMapping
    public ResponseEntity<Rotativo> salvar(@RequestBody @Valid Rotativo rotativo){
        return ResponseEntity.ok(rotativoService.salvar(rotativo));
    }
}
