package org.example.service;

import org.example.model.Cliente;
import org.example.model.Livro;

import java.util.Collection;

public class EmprestimoService {

    private static EmprestimoService instance;

    private EmprestimoService(){}

    public static EmprestimoService getInstance(){
        if(instance == null) instance = new EmprestimoService();

        return instance;
    }

    public void realizarEmprestimo(Cliente cliente, Collection<Livro> livros){

    }

    public void devolverLivros(Collection<Livro> livros){

    }
}
