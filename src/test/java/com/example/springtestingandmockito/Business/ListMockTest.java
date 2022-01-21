package com.example.springtestingandmockito.Business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    //List mock = mock(List.class);

    List<String> mock = mock(List.class);

    @Test
    public void size_basic(){
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    //Not using parameters above

    @Test
    //@Disabled
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    //Using parameters

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("in28Minutes");

        assertEquals("in28Minutes", mock.get(0));
        assertEquals("in28Minutes", mock.get(1));
    }

    //Used an argument matcher which in this case is anyInt()

    @Test
    public void verificationBasics() {
        // SUT
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        // Verify get method is called on mock
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt()); //verify it's called once
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    //Verification in mockito

    @Test
    public void argumentCapturing() {

        //SUT
        mock.add("SomeString");

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());

    }

    //Argument capture

    @Test
    public void multipleArgumentCapturing() {

        //SUT
        mock.add("SomeString1");
        mock.add("SomeString2");

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();

        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));

    }

    //Multiple argument capture for if a method is called multiple times.

}
