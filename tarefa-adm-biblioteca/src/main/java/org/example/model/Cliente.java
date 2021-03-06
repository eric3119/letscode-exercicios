package org.example.model;

import java.util.Objects;

public class Cliente extends BaseModel<Long> {

    @PrimaryKey
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Cliente setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Cliente setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, telefone);
    }

    @Override
    public String toString() {
        return "Cliente [email=" + email + ", id=" + id + ", nome=" + nome + ", telefone=" + telefone + "]";
    }
}
