package com.java7book.chapter11.sync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class UserPrinter {

    public static void main(String[] args) {
        List<Printer> printers = new ArrayList<Printer>();
        printers.add(new Printer("P1"));
        printers.add(new Printer("P2"));
        PrinterManager manager = new PrinterManager(printers);
        for (int i = 0; i < 20; i++) {
            UsePrinter task = new UsePrinter(manager);
            new Thread(task).start();
        }
    }

    private static class UsePrinter implements Runnable {
        private PrinterManager manager;
        public UsePrinter(PrinterManager manager) {
            this.manager = manager;
        }
        public void run() {
            try {
                Printer printer = manager.acquirePrinter();
                printer.print();
                Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
                manager.releasePrinter(printer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
