package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Um site de noticias possui um padrao para os links, sendo ele: site,
 * categoria, subcategoria, data e titulo da noticia.
 * 
 * https://sitenoticas.com.br/negocios/investimentos/2022/04/01/fim-de-semana-com-muita-chuva.html
 * 
 * Crie uma expressao regular para validar se um link inserido é correto.
 */

public class Main {
    public static void main(String[] args) {
        String url = "https://sitenoticas.com.br/negocios/investimentos/2022/04/01/fim-de-semana-com-muita-chuva.html";

        String protocolo = "^(http|https)://";
        Pattern pattern = Pattern.compile(
                protocolo
                        // site
                        + "[a-z.]+.com(.[a-z]+)?"
                        // categoria
                        + "/[a-z]+"
                        // subcategoria
                        + "/[a-z]+"
                        // data yyyy-MM-dd
                        + "/[0-9]{4}"
                        + "/[0-9]{2}"
                        + "/[0-9]{2}"
                        // titulo da noticia
                        + "/[a-z-]+.html");

        Matcher matcher = pattern.matcher(url);

        System.out.println("URL: " + url + "\n\té válida? " + matcher.matches());
    }

}