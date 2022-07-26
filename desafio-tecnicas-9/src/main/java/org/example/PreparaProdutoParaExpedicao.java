package org.example;

public class PreparaProdutoParaExpedicao implements Runnable {

    private final Thread verificaEBloqueiaEstoqueThread;

    public PreparaProdutoParaExpedicao(Thread verificaEBloqueiaEstoqueThread){
        this.verificaEBloqueiaEstoqueThread = verificaEBloqueiaEstoqueThread;
    }

    @Override
    public void run() {
        synchronized (this.verificaEBloqueiaEstoqueThread){
            try {
                this.verificaEBloqueiaEstoqueThread.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        executa();
    }

    private synchronized void executa() {
        System.out.println("Preparando produto para expedição ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Produto preparado para expedição.");
        notify();
    }
}
