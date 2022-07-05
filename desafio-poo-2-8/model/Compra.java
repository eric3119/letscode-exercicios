package model;

import java.math.BigDecimal;
import java.util.List;

public class Compra {
    private List<Produto> produtos;
    private BigDecimal taxaDescontoTotal = BigDecimal.ZERO;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Compra setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
        return this;
    }

    public BigDecimal getTaxaDescontoTotal() {
        return taxaDescontoTotal;
    }

    public Compra setTaxaDescontoTotal(BigDecimal taxaDescontoTotal) {
        this.taxaDescontoTotal = taxaDescontoTotal;
        return this;
    }

    @Override
    public String toString() {
        return "Compra [\n\tprodutos=" + produtos + ",\n\ttaxaDescontoTotal=" + taxaDescontoTotal + "]\n";
    }

}
