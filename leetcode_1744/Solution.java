
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] candiesCount = {7,4,5,3,8};
        int[][] queries = {{0,2,2},{4,2,4},{2,13,1000000000}};

        System.out.println(Arrays.toString(canEat(candiesCount , queries)));


    }

    public static boolean[] canEat(int[] candiesCount, int[][] queries) {

        if(candiesCount == null || queries == null){
            return null;
        }

        int len = queries.length;
        boolean[] res = new boolean[len];

        long[] preSum = new long[candiesCount.length];
        preSum[0] = candiesCount[0];

        for (int i = 1; i < candiesCount.length; i++) {
            preSum[i] = preSum[i-1] + candiesCount[i];
        }

        for (int i = 0; i < len; i++) {
            int[] query = queries[i];
            int favoriteType = query[0], favoriteDay = query[1], dailyCap = query[2];

            long x1 = favoriteDay + 1;
            long y1 = (long) (favoriteDay + 1) * dailyCap;
            long x2 = favoriteType == 0 ? 1 : preSum[favoriteType - 1] + 1;
            long y2 = preSum[favoriteType];

            res[i] = !(x1 > y2 || y1 < x2);
        }







        return res;



    }



}
