package com.company;

public class Main {
    public static char c = 'A';
    public static Object monitor = new Object();

    public static void main(String[] args) {
        SequencePrintLetter sequencePrintLetter1 = new SequencePrintLetter('A', 'B');
        SequencePrintLetter sequencePrintLetter2 = new SequencePrintLetter('B', 'C');
        SequencePrintLetter sequencePrintLetter3 = new SequencePrintLetter('C', 'A');
        new Thread(() -> sequencePrintLetter1.run()).start();
        new Thread(() -> sequencePrintLetter2.run()).start();
        new Thread(() -> sequencePrintLetter3.run()).start();
    }
}


