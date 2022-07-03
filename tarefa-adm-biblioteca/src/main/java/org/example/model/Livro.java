package org.example.model;

public class Livro {
    private String titulo;
    private Double custoDiario;
    private Long maximoDiarias;

    public String getTitulo() {
        return titulo;
    }

    public Livro setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Double getCustoDiario() {
        return custoDiario;
    }

    public Livro setCustoDiario(Double custo) {
        this.custoDiario = custo;
        return this;
    }

    public Long getMaximoDiarias() {
        return this.maximoDiarias;
    }

    public Livro setMaximoDiarias(Long maximoDiarias) {
        this.maximoDiarias = maximoDiarias;
        return this;
    }

    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + "]";
    }
}
