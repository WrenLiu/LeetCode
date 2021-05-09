

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class Solution1482 {


    public static void main(String[] args) {

        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2, k = 3;

        System.out.println(minDays(bloomDay,m,k));
    }

    public static int minDays(int[] bloomDay, int m, int k) {

        if(bloomDay == null || m *k > bloomDay.length){
            return -1;
        }

        int res = 0;

        int len = bloomDay.length;
        int low = bloomDay[0],high = bloomDay[0] ;
        for (int i = 0; i < len; i++) {
            low = Math.min(low , bloomDay[i]);
            high = Math.max(high , bloomDay[i]);
        }

        if(low == high){
            return low;
        }

        int mid = 0;

        while(low <= high){

            mid = (high + low) >> 1;

            if(canMake(bloomDay ,mid, m , k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

//    [1,10,3,10,2]
//    现需要制作 m 束花。制作花束时，需要使用花园中相邻的 k 朵花
    private static boolean canMake(int[] bloomDay, int days, int m, int k) {

        int cluster = 0;
        int flowers = 0;
        int len = bloomDay.length;


        for (int i = 0; i < len; i++) {

            if(bloomDay[i] <= days){
                flowers ++;

                if(flowers == k){
                    cluster++;
                    flowers = 0;
                }

            }else{
                flowers = 0;
            }


        }

        return cluster >= m;


    }

}
