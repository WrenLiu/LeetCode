

import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[][] envelopes = {{1,2},{2,3},{3,4},{3,5},{4,5},{5,5},{5,6},{6,7},{7,8}};
//        int[][] envelopes = {{46,89},{50,53},{52,68},{72,45},{77,81}};
        System.out.println(maxEnvelopes_BinarySearch(envelopes));

    }

    public static int maxEnvelopes_BinarySearch(int[][] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];

        Arrays.sort(nums, (a, b) -> (a[0] == b[0] ? b[1]-a[1] : a[0]-b[0]));

        int maxLen = 0;


        for (int i = 0; i < nums.length; i++) {

            int h = nums[i][1];

            int left = 0,right = maxLen;

            while(left < right){

                int mid = left + (right-left)/2;

                if(dp[mid] < h){
                    left = mid+1;
                }else{
                    right = mid;
                }

            }
            dp[left] = h;
            if(left == maxLen){
                maxLen++;
            }




        }

        return maxLen;






    }


    public static int maxEnvelopes(int[][] envelopes) {

        if(envelopes == null || envelopes.length == 0){
            return 0;
        }else if(envelopes.length == 1){
            return 1;
        }

        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]){
                    return a[1] - b[1];
                }else {
                    return a[0] - b[0];
                }
            }
        });

//        for (int i = 0; i < envelopes.length; i++) {
//            System.out.println(envelopes[i][0]+" "+envelopes[i][1]);
//        }

        int[] dp = new int[envelopes.length];
        int maxLen = 1;

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1 );
                }
                maxLen = Math.max(maxLen,dp[i]);
                
            }
        }



        return maxLen;


    }


}
