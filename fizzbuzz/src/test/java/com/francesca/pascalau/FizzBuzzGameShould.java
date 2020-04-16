package com.francesca.pascalau;

import com.francesca.pascalau.kata.FizzBuzzGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzGameShould {

    private FizzBuzzGame game = new FizzBuzzGame();

//    @Test
//    public void
//    return_numbers_from_1_to_10(){
//        String expectedNumbers =
//                "1\n" +
//                "2\n" +
//                "3\n" +
//                "4\n" +
//                "5\n" +
//                "6\n" +
//                "7\n" +
//                "8\n" +
//                "9\n" +
//                "10\n";
//
//        String actualNumbers = game.count();
//        assertEquals(expectedNumbers, actualNumbers);
//    }

//    @Test
//    public void
//    return_Fizz_for_numbers_divisible_with_3(){
//        String expectedNumbers =
//                "1\n" +
//                "2\n" +
//                "3 Fizz\n" +
//                "4\n" +
//                "5\n" +
//                "6 Fizz\n" +
//                "7\n" +
//                "8\n" +
//                "9 Fizz\n" +
//                "10\n";
//
//        String actualNumbers = game.count();
//        assertEquals(expectedNumbers, actualNumbers);
//    }

    @Test
    public void
    return_Fizz_for_numbers_divisible_with_5(){
        String expectedNumbers =
                "1\n" +
                "2\n" +
                "3 Fizz\n" +
                "4\n" +
                "5 Buzz\n" +
                "6 Fizz\n" +
                "7\n" +
                "8\n" +
                "9 Fizz\n" +
                "10 Buzz\n" +
                "11\n" +
                "12 Fizz\n" +
                "13\n" +
                "14\n" +
                "15 FizzBuzz\n" +
                "16\n" +
                "17\n" +
                "18 Fizz\n" +
                "19\n" +
                "20 Buzz\n";

        String actualNumbers = game.count();
        assertEquals(expectedNumbers, actualNumbers);
    }
}
