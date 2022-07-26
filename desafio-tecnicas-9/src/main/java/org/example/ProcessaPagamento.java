package org.example;

public class ProcessaPagamento implements Runnable {

    @Override
    public synchronized void run() {
        System.out.println("Processando Pagamento ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Pagamento Processado.");
        notify();
    }
}
