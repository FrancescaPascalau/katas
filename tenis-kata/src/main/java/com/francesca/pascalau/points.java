package com.francesca.pascalau;

public enum Points {

    LOVE(0),
    FIFTEEN(15),
    THIRTY(30),
    FORTY(40),
    ADVANTAGE(1);

    private final int value;

    Points(int value) {
        this.value = value;
    }
}
