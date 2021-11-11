package com.company;

import static com.company.Main.monitor;

class SequencePrintLetter extends Thread {
    private char currentLetter;
    private char nextLetter;

    public SequencePrintLetter(char currentLetter, char nextLetter) {
        this.currentLetter = currentLetter;
        this.nextLetter = nextLetter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (monitor) {
                try {
                    while (Main.c != currentLetter)
                        monitor.wait();
                    System.out.print(currentLetter);
                    Main.c = nextLetter;
                    monitor.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
