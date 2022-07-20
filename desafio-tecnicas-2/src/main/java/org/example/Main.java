package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Um funcionário recebe uma comissão de 0.5% sobre o valor do seu dia
 * trabalhado.
 * Criar uma função para receber o valor do salário mensal e o ano e partir
 * dessas informações calcular previsão do salário mês a mês.
 * Considerar apenas os dias úteis (segunda a sexta).
 */

public class Main {
    private static Locale ptBR = new Locale("pt", "BR");

    public static void main(String[] args) {
        previsaoSalarioAnual();
    }

    private static void previsaoSalarioAnual() {
        BigDecimal comissaoDia = BigDecimal.valueOf(0.05);
        BigDecimal salarioMensal = BigDecimal.valueOf(2000);
        int ano = Year.now().getValue();

        for (int i = 1; i <= 12; i++) {
            int diasTrabalhados = DateUtils.getQtdDiasUteisMes(Month.of(i), ano);
            BigDecimal salarioDiario = salarioMensal.divide(BigDecimal.valueOf(diasTrabalhados), 2,
                    RoundingMode.HALF_UP);
            BigDecimal valorComissaoDia = comissaoDia.multiply(salarioDiario);
            BigDecimal valorComissaoMes = valorComissaoDia.multiply(BigDecimal.valueOf(diasTrabalhados));

            System.out.println("Salário do mês de " + Month.of(i).getDisplayName(TextStyle.FULL, ptBR) + " "
                    + salarioMensal.add(valorComissaoMes).setScale(2, RoundingMode.HALF_UP));
        }

    }

}