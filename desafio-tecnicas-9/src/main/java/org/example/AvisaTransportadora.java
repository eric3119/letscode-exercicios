package org.example;

public class AvisaTransportadora implements Runnable {

    private final Thread preparaProdutoParaExpedicaoThread;

    public AvisaTransportadora(Thread preparaProdutoParaExpedicaoThread){
        this.preparaProdutoParaExpedicaoThread = preparaProdutoParaExpedicaoThread;
    }

    @Override
    public void run() {
        synchronized (this.preparaProdutoParaExpedicaoThread){
            try {
                this.preparaProdutoParaExpedicaoThread.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        executa();
    }

    private synchronized void executa(){
        System.out.println("Notificando transportadora ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Transportadora notificada.");
        notify();
    }
}
