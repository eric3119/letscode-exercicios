package org.example.implementations;

public class Animal {
    private boolean voador;

    public boolean isVoador() {
        return voador;
    }

    public Animal setVoador(boolean voador) {
        this.voador = voador;
        return this;
    }

    @Override
    public String toString() {
        return "Animal [voador=" + voador + "]";
    }
    
    
}
