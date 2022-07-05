package descontos;

import java.math.BigDecimal;

import model.Compra;

public class Desconto10 extends Desconto {

    // private Desconto proximoDesconto;

    // public Desconto10() {
    // }

    // public Desconto10(Desconto proximoDesconto) {
    //     this.proximoDesconto = proximoDesconto;
    // }

    @Override
    public void aplicar(Compra compra) {
        if (compra.getProdutos().size() >= 10 && compra.getProdutos().size() < 15)
            compra.setTaxaDescontoTotal(new BigDecimal("0.08"));
        else if (this.proximoDesconto != null)
            this.proximoDesconto.aplicar(compra);
    }

}
