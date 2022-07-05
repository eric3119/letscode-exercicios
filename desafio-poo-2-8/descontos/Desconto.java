package descontos;

import model.Compra;

public abstract class Desconto {

    protected Desconto proximoDesconto;

    public Desconto() {
    }

    public Desconto(Desconto desconto) {
    }

    public abstract void aplicar(Compra compra);
}
