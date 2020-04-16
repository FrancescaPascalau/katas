package com.francesca.pascalau.romannumbers;

import com.francesca.pascalau.kata.RomanNumbers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumbersShould {

    private RomanNumbers romanNumbers;
    private static final int ONE = 1;
    private static final int THOUSAND = 1000;

    @Before
    public final void before(){
        romanNumbers = new RomanNumbers();
    }

    @Test
    public void print_I_when_inserting_1(){
        String oneOutput = "I";
        String output = romanNumbers.romanFor(ONE);
        assertEquals(output, oneOutput);
    }

    @Test
    public void print_M_when_inserting_1000(){
        String oneOutput = "M";
        String output = romanNumbers.romanFor(THOUSAND);
        assertEquals(output, oneOutput);
    }

    @Test
    public void print_roman_number_when_inserting_arabic_number(){
        int arabic = 38;
        String roman = "XXXVIII";
        String output = romanNumbers.romanFor(arabic);
        assertEquals(roman, output);
    }
}
