package com.mockitopractice.mockito_demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private BusinessImpl businessImplMock;

    @Test
    void findGreatestFromAllData_basicScenario(){

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1,2,3,4,5});

        assertEquals(5, businessImplMock.findGreatestFromAllData());

    }

    @Test
    void findGreatestFromAllData_OneValue(){

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1});

        assertEquals(1, businessImplMock.findGreatestFromAllData());

    }

    @Test
    void findGreatestFromAllData_NoValue(){

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});

        assertEquals(Integer.MIN_VALUE, businessImplMock.findGreatestFromAllData());

    }



}
