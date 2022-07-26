package org.example;

public class EmiteNotaFiscal implements Runnable {

    private final Thread verificaEBloqueiaEstoqueThread;

    public EmiteNotaFiscal(Thread verificaEBloqueiaEstoqueThread){
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
        System.out.println("Emitindo nota fiscal ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Nota fiscal emitida.");
        notify();
    }
}
