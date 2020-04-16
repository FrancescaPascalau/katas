package com.francesca.pascalau.kata;

public class FizzBuzzGame {

    private static final int MIN = 2;
    private static final int MAX = 20;
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static String numbers = "1\n";
    private int index;

    public String count() {
        for(index = MIN; index <= MAX; index++) {
            if(index % THREE == 0 && index % FIVE == 0){
                numbers += divisibleWithThreeAndfive(String.valueOf(index));
                continue;
            }
            else if(index % THREE == 0) {
                numbers += divisibleWithThree(String.valueOf(index));
                continue;
            }
            else if(index % FIVE == 0) {
                numbers += divisibleWithFive(String.valueOf(index));
                continue;
            }
            numbers += index + "\n";
        }
        return numbers;
    }

    private String divisibleWithThree(String number) {
        return number + " Fizz\n";
    }

    private String divisibleWithFive(String number) {
        return number + " Buzz\n";
    }

    private String divisibleWithThreeAndfive(String number) {
        return number + " FizzBuzz\n";
    }
}
