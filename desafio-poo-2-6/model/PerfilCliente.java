package model;

import java.util.ArrayList;
import java.util.List;

public abstract class PerfilCliente<T extends Investimento> {

    List<Investimento> investimentos = new ArrayList<>();

    public abstract void contratarInvestimento(T investimento);

    public List<Investimento> getCarteiraInvestimentos(){
        return this.investimentos;
    }
}
