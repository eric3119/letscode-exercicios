package org.example;

import java.util.List;
import java.util.stream.Collectors;

import org.example.implementations.Animal;
import org.example.interfaces.Verificador;

public class Main {

        public static void main(String[] args) {
                List<Animal> animais = List.of(new Animal().setVoador(true), new Animal());

                System.out.println(filtrar(animais, (animal) -> animal.isVoador()));
        }

        static List<Animal> filtrar(List<Animal> animais, Verificador verificador) {
                return animais.stream().filter(verificador::verificar).collect(Collectors.toList());
        }
}