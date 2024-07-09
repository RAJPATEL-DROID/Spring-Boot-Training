package org.springdemo;

public class Calc implements Interf {

    @Override
    public int divide(int a, int b) {
        if(b != 0)
            return a/b;
        return 0;
    };
}
