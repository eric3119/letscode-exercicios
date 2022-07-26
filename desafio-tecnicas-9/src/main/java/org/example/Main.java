package org.example;

public class Main {
    public static void main(String[] args) {
        Thread processaPagamentoThread = new Thread(new ProcessaPagamento(), "ProcessaPagamento");
        processaPagamentoThread.start();
        // O bloqueio do estoque nao pode ocorrer antes do pagamento.
        Thread verificaEBloqueiaEstoqueThread = new Thread(new VerificaEBloqueiaEstoque(processaPagamentoThread), "VerificaEBloqueiaEstoque");
        verificaEBloqueiaEstoqueThread.start();
        // Nota fiscal deve ser emitida logo apos a verificacao do estoque.
        Thread emiteNotaFiscalThread = new Thread(new EmiteNotaFiscal(verificaEBloqueiaEstoqueThread), "EmiteNotaFiscal");
        emiteNotaFiscalThread.start();
        // Envio de email da NF nao pode ser executado antes da emissao.
        Thread enviaEmailNotaFiscalThread = new Thread(new EnviaEmailNotaFiscal(emiteNotaFiscalThread), "EnviaEmailNotaFiscal");
        enviaEmailNotaFiscalThread.start();
        // Preparar o produto para expediçao e avisar a transportadora deve ser iniciado logo apos o bloqueio no estoque.
        Thread preparaProdutoParaExpedicaoThread = new Thread(new PreparaProdutoParaExpedicao(verificaEBloqueiaEstoqueThread), "PreparaProdutoParaExpedicao");
        preparaProdutoParaExpedicaoThread.start();
        // Avisar a transportadora nao pode ocorrer antes de preparar o produto para expediçao.
        Thread avisaTransportadoraThread = new Thread(new AvisaTransportadora(preparaProdutoParaExpedicaoThread), "AvisaTransportadora");
        avisaTransportadoraThread.start();

    }
}