package descontos;

import java.math.BigDecimal;

import model.Compra;

public class Desconto15 extends Desconto {

    // private Desconto proximoDesconto;

    // public Desconto15() {
    // }

    // public Desconto15(Desconto proximoDesconto) {
    //     this.proximoDesconto = proximoDesconto;
    // }

    @Override
    public void aplicar(Compra compra) {
        if (compra.getProdutos().size() >= 15)
            compra.setTaxaDescontoTotal(new BigDecimal("0.1"));
        else if (this.proximoDesconto != null)
            this.proximoDesconto.aplicar(compra);
    }

}
