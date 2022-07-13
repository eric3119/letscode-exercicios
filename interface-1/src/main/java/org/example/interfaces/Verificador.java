package org.example.interfaces;

import org.example.implementations.Animal;

@FunctionalInterface
public interface Verificador {
    boolean verificar(Animal animal);
}
