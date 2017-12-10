package com.java7book.chapter12;

public final class Sequence implements Comparable<Sequence> {
    private final int sequenceNumber;
    public Sequence(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
    public int compareTo(Sequence sequence) {
        return Integer.compare(sequenceNumber, sequence.sequenceNumber);
    }
}
