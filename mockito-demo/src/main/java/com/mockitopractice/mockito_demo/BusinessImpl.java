package com.mockitopractice.mockito_demo;

public class BusinessImpl {
    private DataService dataService;

    public BusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int findGreatestFromAllData(){
        int[] data = dataService.retrieveAllData();

        int max = Integer.MIN_VALUE;

        for(int val : data){
            if(val > max){
                max = val;
            }
        }

        return max;
    }
}


interface DataService{
   int[] retrieveAllData();

}
