package model;

public class ClienteConservador extends PerfilCliente<RendaFixa> {

    @Override
    public void contratarInvestimento(RendaFixa investimento) {
        this.investimentos.add(investimento);
    }

}
