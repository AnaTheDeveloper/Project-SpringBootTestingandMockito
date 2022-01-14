package com.example.springtestingandmockito.Business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplTest {

    @Test
    public void calculateSum_basic(){

        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        int actualResult = someBusiness.calculateSum(new int[] {1,2,3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void calculateSum_empty() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] { });
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void calculateSum_oneValue() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] { 5});
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

}