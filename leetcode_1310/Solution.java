

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,3,4,8};
        int[][] queries = {{0,1},{1,2},{0,3},{3,3}};
//        2,7,14,8
        System.out.println(Arrays.toString(xorQueries(arr,queries)));
    }

    // 前缀和
    public static int[] xorQueries(int[] arr, int[][] queries) {

        if(arr == null || queries == null){
            return null;
        }

        int[] res = new int[queries.length];
        int[] sum = new int[arr.length];


        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i-1] ^ arr[i];
        }


        for (int i = 0; i < res.length; i++) {

            if(queries[i][0] == 0){
                res[i] = sum[queries[i][1]];
            }else{
                res[i] = sum[queries[i][0]-1] ^ sum[queries[i][1]];
            }

        }

        return res;
    }


    public static int[] xorQueries_mine(int[] arr, int[][] queries) {

        if(arr == null || queries == null){
            return null;
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int left = queries[i][0];
            int right = queries[i][1];
            for (int j = left; j <= right; j++) {
                res[i] ^= arr[j];

            }
        }
        return res;


    }


}
