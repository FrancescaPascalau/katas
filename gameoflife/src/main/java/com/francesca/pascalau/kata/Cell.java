package com.francesca.pascalau.kata;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cell {
    private int X;
    private int Y;
    private int state;
}
