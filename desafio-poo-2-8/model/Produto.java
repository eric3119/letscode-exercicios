package model;

import java.math.BigDecimal;

public class Produto {
    private String nome;
    private BigDecimal valor;
    public String getNome() {
        return nome;
    }
    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public Produto setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }
    @Override
    public String toString() {
        return "\n\tProduto [\n\tnome=" + nome + ",\n\tvalor=" + valor + "]\n";
    }    
}
