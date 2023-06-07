package com.example.mydesign.controler;

public class FilterActivityController {


    public static int[] getIntArrFromTheFilter(boolean[] arr, int lowP, int highP, boolean sort_by_price){

        int[] ans = new int[12];
        int index =0;
        for (boolean userCheckBoxChoice :arr) {
            if(userCheckBoxChoice){
                ans[index] = 1;
            }else {
                ans[index] = 0;
            }
            index++;
        }
        ans[index++] = lowP;
        ans[index++] = highP;
        if(sort_by_price){
            ans[index] = 1;
        }else{
            ans[index] = 0;
        }
        return ans;
    }

}
