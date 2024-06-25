package org.junitdemo;

public class MyMath {

    public int Sum(int[] numbers){
        int sum = 0;

        for(var i : numbers){
            sum += i;
        }

        return sum;
    }

}
