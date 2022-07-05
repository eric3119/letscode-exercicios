package descontos;

import java.math.BigDecimal;

import model.Compra;

public class Desconto5 extends Desconto {

    // private Desconto proximoDesconto;

    // public Desconto5() {
    // }

    // public Desconto5(Desconto proximoDesconto) {
    //     this.proximoDesconto = proximoDesconto;
    // }

    @Override
    public void aplicar(Compra compra) {
        if (compra.getProdutos().size() >= 5 && compra.getProdutos().size() < 10)
            compra.setTaxaDescontoTotal(new BigDecimal("0.05"));
        else if (this.proximoDesconto != null)
            this.proximoDesconto.aplicar(compra);
    }

}
