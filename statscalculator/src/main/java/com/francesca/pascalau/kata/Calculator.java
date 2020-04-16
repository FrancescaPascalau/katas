package com.francesca.pascalau.kata;

import java.util.List;

public class Calculator {

    private Integer MIN = Integer.MAX_VALUE;
    private Integer MAX = Integer.MIN_VALUE;

    public List<Integer> calculate(List<Integer> input) {
        return input;
    }

    public Integer getMinimNumber(List<Integer> integerList) {
        for(Integer integerValue : integerList){
            if(integerValue < MIN){
                MIN = integerValue;
            }
        }
        return MIN;
    }

    public Integer getMaximNumber(List<Integer> integerList) {
        for(Integer integerValue : integerList){
            if(integerValue > MAX){
                MAX = integerValue;
            }
        }
        return MAX;
    }

    public Integer getSize(List<Integer> input) {
        return input.size();
    }

    public Double getAverage(List<Integer> input) {
        Integer size = getSize(input);
        Double average;
        Double sum = 0.0;
        for(Integer i : input){
            sum += i;
        }
        average = sum/size;
        return average;
    }
}
