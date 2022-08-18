package com.bbletscode.rotativo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Rotativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "veiculo", nullable = false)
    private Veiculo veiculo;

    @ManyToOne()
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime entrada;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Nullable
    private LocalDateTime saida;

    @Override
    public String toString() {
        if (this.cliente != null && this.veiculo != null)
            return this.cliente.getNome() + "@" + this.veiculo.getPlaca();
        else
            return super.toString() + "::id::" + this.getId();
    }
}
