package org.example;

import java.util.HashMap;
import java.util.Map;

public class ModeloVariaveis {
    private static Map<String, String> variaveis = new HashMap<>();

    public static void addVariavel(String linha) {
        String variavel = linha.split("=")[0].trim();
        String valor = linha.split("=")[1].trim();

        addVariavel(variavel, valor);
    }

    public static void addVariavel(String key, String value) {
        variaveis.put(key, value);
    }

    public static String get(String key){
        return variaveis.get(key);
    }
}
