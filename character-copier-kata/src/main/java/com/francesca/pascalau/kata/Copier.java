package com.francesca.pascalau.kata;

public class Copier {
    private Source source;
    private Destination destination;

    public Copier(Source source, Destination destination) {
        this.source = source;
        this.destination = destination;
    }

    public void copy() {
        char c = ' ';
        while (c != '\n'){
            c = source.getChar();
            destination.setChar(c);
        }
    }
}
