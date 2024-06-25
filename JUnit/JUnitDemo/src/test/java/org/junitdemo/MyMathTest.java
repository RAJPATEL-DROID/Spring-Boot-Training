package org.junitdemo;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyMathTest {

    MyMath myMath = new MyMath();

    @Test
    void Sum_FourMemberArray() {
        assertEquals(myMath.Sum(new int[]{12,3,4,112}),131);
    }

    @Test
    void Sum_ZeroLengthArray(){
        assertEquals(myMath.Sum(new int[]{}),0);
    }
}