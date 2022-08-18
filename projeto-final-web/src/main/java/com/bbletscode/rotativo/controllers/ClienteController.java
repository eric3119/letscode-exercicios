package com.bbletscode.rotativo.controllers;

import com.bbletscode.rotativo.models.Cliente;
import com.bbletscode.rotativo.models.Rotativo;
import com.bbletscode.rotativo.repositories.ClienteRepository;
import com.bbletscode.rotativo.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(description = "Listar clientes")
    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        return ResponseEntity.ok(clienteService.findAll());
    }

    @Operation(description = "Registrar um cliente")
    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody @Valid Cliente cliente){
        return ResponseEntity.ok(clienteService.salvar(cliente));
    }
}
