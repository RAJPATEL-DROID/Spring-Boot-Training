package com.mockitopractice.mockito_demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessImplTest {

    @Test
    void test() {

        DataServiceStubs dataServiceStubs = new DataServiceStubs();

        BusinessImpl businessImpl = new BusinessImpl(dataServiceStubs);

        int result = businessImpl.findGreatestFromAllData();

        assertEquals(5, result);
    }
}

class DataServiceStubs implements DataService {
    @Override
    public int[] retrieveAllData(){
        return new int[]{1,2,3,4,5};
    }
}