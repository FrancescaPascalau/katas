package com.francesca.pascalau.calculator;

import com.francesca.pascalau.kata.Calculator;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculatorShould {

    private Calculator calculator;
    private static final List<Integer> INPUT = Arrays.asList(2, 4, 56, -8, 0);

    @Before
    public final void before() {
         calculator =  new Calculator();
    }

    @Test
    public void print_the_numbers_inserted(){
        List<Integer> numbers = calculator.calculate(INPUT);

        assertEquals(numbers, INPUT);
    }

    @Test
    public void print_minimal_number_inserted(){
        Integer min = calculator.getMinimNumber(INPUT);
        assertEquals(INPUT.get(3), min);
    }

    @Test
    public void print_maximal_number_inserted(){
        Integer max = calculator.getMaximNumber(INPUT);
        assertEquals(INPUT.get(2), max);
    }

    @Test
    public void print_the_size_of_the_NumberList_inserted(){
        Integer numbers = calculator.getSize(INPUT);
        Integer actualSize = INPUT.size();
        assertEquals(actualSize, numbers);
    }

    @Test
    public void print_the_average_of_the_NumberList(){
        Double average = calculator.getAverage(INPUT);
        Double actualAverage = 10.8;
        assertEquals(actualAverage, average);
    }
}
