package org.example;

public class EnviaEmailNotaFiscal implements Runnable {

    private final Thread emiteNotaFiscalThread;

    public EnviaEmailNotaFiscal(Thread emiteNotaFiscalThread){
        this.emiteNotaFiscalThread = emiteNotaFiscalThread;
    }

    @Override
    public void run() {
        synchronized (this.emiteNotaFiscalThread) {
            try {
                this.emiteNotaFiscalThread.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        executa();
    }

    private synchronized void executa(){
        System.out.println("Enviando email com a nota fiscal do cliente ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Email com a nota fiscal do cliente enviado.");
        notify();
    }
}
