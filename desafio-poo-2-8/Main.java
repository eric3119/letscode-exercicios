import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import descontos.Desconto;
import descontos.Desconto10;
import descontos.Desconto15;
import descontos.Desconto5;
import model.Compra;
import model.Produto;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            produtos.add(
                    new Produto()
                            .setNome("Produto " + i)
                            .setValor(BigDecimal.valueOf(i)));
        }

        Compra compra = new Compra().setProdutos(produtos);

        List<Desconto> descontos = List.of(
                new Desconto15(),
                new Desconto10(),
                new Desconto5());

        for (Desconto desconto : descontos) {
            desconto.aplicar(compra);
        }

        System.out.println("Desconto aplicado: " + NumberFormat.getPercentInstance().format(compra.getTaxaDescontoTotal()));
    }
}