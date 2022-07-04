package org.example.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Emprestimo extends BaseModel<Long> {

    @PrimaryKey
    private Long id;
    private Livro livro;
    private Cliente cliente;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;

    public Livro getLivro() {
        return livro;
    }

    public Emprestimo setLivro(Livro livro) {
        this.livro = livro;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Emprestimo setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Emprestimo setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
        return this;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public Emprestimo setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente, dataDevolucao, dataEmprestimo, livro);
    }

    @Override
    public String toString() {
        return "\n\tEmprestimo [\n\t\tcliente=" + cliente + ", \n\t\tdataDevolucao=" + dataDevolucao
                + ", \n\t\tdataEmprestimo="
                + dataEmprestimo + ", \n\t\tlivro=" + livro + "]";
    }

}
