package com.example.springtestingandmockito.Business;

import com.example.springtestingandmockito.Data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Stubs

class SomeDataServiceStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] { 1, 2, 3 };
    }
}

class SomeDataServiceEmptyStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] { };
    }
}

class SomeDataServiceOneElementStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] { 5 };
    }
}

/*
Disadvantages of using Stub
    - You could have hundreds of stub classes
    - Very hard to maintain
    - When you look at the data stub, you would not know exactly what the data is treating.
    - Can give stubs very good names to keep track of them. But as stubs become more and more complex it becomes very difficult to give it a good name.
 */

/*
    So instead of creating a direct class like this, instead of creating a specific class like this with the mocks, you can programmatically create classes.
 */

public class SomeBusinessStubTest {

    //unit tests using Stub

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceEmptyStub());
        int actualResult = business.calculateSumUsingDataService();//new int[] {}
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceOneElementStub());
        int actualResult = business.calculateSumUsingDataService();//new int[] { 5 }
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }
}
