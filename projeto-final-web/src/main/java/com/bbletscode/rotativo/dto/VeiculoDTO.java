package com.bbletscode.rotativo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO {
    private Integer id;
    private String modelo;
    private String placa;
    private String cor;
}