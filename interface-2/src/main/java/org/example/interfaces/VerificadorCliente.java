package org.example.interfaces;

import org.example.implementations.Cliente;
import org.example.implementations.Cliente.Sexo;
import org.example.utils.CalculaIdade;

public class VerificadorCliente extends Verificador<Cliente> {
    @Override
    public boolean test(Cliente cliente) {
        Long idade = CalculaIdade.calcular(cliente);
        return cliente.getSexo().equals(Sexo.MASCULINO) && idade >= 18;
    }
}
