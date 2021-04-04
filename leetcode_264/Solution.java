class Solution {
    public int nthUglyNumber(int n) {

        if(n <= 0 || n > 1690){
            return -1;
        }

        int[] dp = new int[n];
        dp[0] = 1;


        int index2 = 0,index3 = 0,index5 = 0;

        for (int i = 1; i < n; i++) {

            int n2 = dp[index2]*2 , n3 = dp[index3]*3, n5 = dp[index5]*5;

            // 状态转移方程
            dp[i] = Math.min(dp[index2]*2 , Math.min(dp[index3] * 3,dp[index5] *5));

            // 判断条件，满足即对应索引加1
            if(dp[i] == n2) index2++;
            if(dp[i] == n3) index3++;
            if(dp[i] == n5) index5++;

        }

        return dp[n-1];

    }

}