package org.example;

public class VerificaEBloqueiaEstoque implements Runnable {

    private final Thread pagamentoThread;

    public VerificaEBloqueiaEstoque(Thread pagamento){
        this.pagamentoThread = pagamento;
    }

    @Override
    public void run() {
        synchronized (pagamentoThread) {
            try {
                pagamentoThread.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        processa();
    }

    private synchronized void processa(){
        System.out.println("Verificando e bloqueando estoque ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Estoque verificado e bloqueado.");
        notifyAll();
    }
}
