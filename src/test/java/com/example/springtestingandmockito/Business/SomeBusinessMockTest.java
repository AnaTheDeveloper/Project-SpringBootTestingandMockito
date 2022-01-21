package com.example.springtestingandmockito.Business;

import com.example.springtestingandmockito.Data.SomeDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {

    @InjectMocks //Create instance
    SomeBusinessImpl business;

    @Mock //Put this mock in that instance above
    SomeDataService dataServiceMock;

    @Test
    public void calculateSumUsingDataService_basicLongMethod() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        SomeDataService someDataServiceMock = mock(SomeDataService.class);
        //We want to mock the service class
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
        //When this method is called I expect this to be returned
        someBusiness.setSomeDataService(someDataServiceMock);
        //Setting mock
        int actualResult = someBusiness.calculateSumUsingDataService();
        int exepectedResult = 6;
        assertEquals(exepectedResult, actualResult);

    }

    @Test
    public void calculateSumUsingDataService_basicTidyMethod() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
        assertEquals(6, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 5 });
        assertEquals(5, business.calculateSumUsingDataService());
    }
}
