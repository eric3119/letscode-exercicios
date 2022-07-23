package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinhaModeloFormatter {
    String input;
    List<String> valores;

    LinhaModeloFormatter(){}

    LinhaModeloFormatter(String input, List<String> valores) {
        this.input = input;
        this.valores = valores;
    }

    public String getLinhaFormatada(){
        String res = input
                .replaceAll("<%\\s*\\w+\\s*%>", "^") // escape tags
                .replaceAll("%", "%%") // escape %
                .replaceAll("\\^", "%s"); // para exibir as tags na string formatada

        return String.format(res, valores.toArray());
    }

    public LinhaModeloFormatter setLinha(String linha) {
        input = linha;
        Pattern pattern = Pattern.compile("<%\\s*(\\w+)\\s*%>");
        List<String> variaveisParaSubstituir = new ArrayList<>();

        Matcher matcher = pattern.matcher(linha);

        while (matcher.find()) {
            variaveisParaSubstituir.add(ModeloVariaveis.get(matcher.group(1).trim()));
        }

        this.valores = variaveisParaSubstituir;

        return this;
    }

    @Override
    public String toString() {
        return this.getLinhaFormatada();
    }
}