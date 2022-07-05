package model;

public class ClienteModerado extends PerfilCliente<RendaFixa> {

    @Override
    public void contratarInvestimento(RendaFixa investimento) {
        this.investimentos.add(investimento);
    }
    
}
