package org.example.service;

import java.math.BigDecimal;
import java.util.List;

import org.example.model.Cliente;
import org.example.model.Emprestimo;
import org.example.repository.EmprestimoRepository;

public class CalcularMultaService {
    private EmprestimoRepository emprestimoRepository = EmprestimoRepository.getInstance();
    private List<CalcularMulta> calcularMultaList;

    public CalcularMultaService(List<CalcularMulta> calcularMultaList) {
        this.calcularMultaList = calcularMultaList;
    }

    public BigDecimal calcularMultas(Cliente cliente) {
        BigDecimal totalMultas = new BigDecimal(0);
        List<Emprestimo> emprestimos = this.emprestimoRepository.filterDevolucaoPendente(cliente);

        for (Emprestimo emprestimo : emprestimos) {
            for (CalcularMulta calcularMulta : calcularMultaList) {
                BigDecimal multa = calcularMulta.calcular(emprestimo);
                totalMultas = totalMultas.add(multa);
            }
        }

        return totalMultas;
    }
}
