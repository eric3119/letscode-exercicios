package org.example.service;

import java.util.List;

import org.example.model.Cliente;
import org.example.model.Emprestimo;
import org.example.repository.EmprestimoRepository;

public class ValidadorEmprestimosQuantidadeMaxima implements ValidadorEmprestimos {

    private final Integer QUANTIDADE_MAXIMA_PERMITIDA = 2;
    private EmprestimoRepository emprestimoRepository = EmprestimoRepository.getInstance();

    @Override
    public void validar(List<Emprestimo> emprestimos) {
        if(emprestimos.size() == 0) return;

        final Cliente cliente = emprestimos.get(0).getCliente();

        if(cliente == null) return;

        final List<Emprestimo> emprestimosPendentes = this.emprestimoRepository.filterDevolucaoPendente(cliente);

        if (emprestimosPendentes.size() + emprestimos.size() > QUANTIDADE_MAXIMA_PERMITIDA)
            throw new RuntimeException(
                    String.format("Quantidade máxima de livros emprestados atingida: Excedeu %d livro(s)",
                            (emprestimosPendentes.size() + emprestimos.size()) - QUANTIDADE_MAXIMA_PERMITIDA));
    }    
}
