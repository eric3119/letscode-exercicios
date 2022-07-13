package org.example.interfaces;

@FunctionalInterface
public interface Verificador<T> {
    boolean verificar(T entity);
}
