package org.example.interfaces;

import org.example.implementations.Cliente;
import org.example.implementations.Cliente.Sexo;
import org.example.utils.CalculaIdade;

public class VerificadorCliente implements Verificador<Cliente> {
    public boolean verificar(Cliente entity) {
        Long idade = CalculaIdade.calcular(entity);
        return entity.getSexo().equals(Sexo.MASCULINO) && idade >= 18;
    }
}
