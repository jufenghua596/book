package com.java7book.chapter11.sync;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Semaphore;

public class PrinterManager {
    private final Semaphore semaphore;
    private final List<Printer> printers = new ArrayList<>();
    public PrinterManager(Collection<? extends Printer> printers) {
        this.printers.addAll(printers);
        this.semaphore = new Semaphore(this.printers.size(), true);
    }
    public Printer acquirePrinter() throws InterruptedException {
        semaphore.acquire();
        return getAvailablePrinter();
    }
    public void releasePrinter(Printer printer) {
        putBackPrinter(printer);
        semaphore.release();
    }
    private synchronized Printer getAvailablePrinter() {
        Printer result = printers.get(0);
        printers.remove(0);
        return result;
    }
    private synchronized void putBackPrinter(Printer printer) {
        printers.add(printer);
    }
}
