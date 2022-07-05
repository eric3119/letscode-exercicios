package model;

public class ClienteArrojado extends PerfilCliente<RendaVariavel> {

    @Override
    public void contratarInvestimento(RendaVariavel investimento) {
        this.investimentos.add(investimento);
    }
    
}
