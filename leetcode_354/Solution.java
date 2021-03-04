

import java.lang.reflect.Array;
import java.util.*;

public class Solution354 {

    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
//        int[][] envelopes = {{46,89},{50,53},{52,68},{72,45},{77,81}};
        System.out.println(maxEnvelopes(envelopes));

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

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1 );
                }
                
            }
        }


//        System.out.println(Arrays.toString(dp));
        Arrays.sort(dp);







        return dp[dp.length-1];


    }


}
