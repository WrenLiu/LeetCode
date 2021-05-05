import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {3,4,2};

        System.out.println(deleteAndEarn(nums));

    }

    public static int[] cnts = new int[10009];
    
    public static int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int x : nums) {
            cnts[x]++;
            max = Math.max(max, x);
        }
        // f[i][0] 代表「不选」数值 i；f[i][1] 代表「选择」数值 i
        int[][] f = new int[max + 1][2];
        for (int i = 1; i <= max; i++) {
            f[i][1] = f[i - 1][0] + i * cnts[i];
            f[i][0] = Math.max(f[i - 1][1], f[i - 1][0]);
        }
        return Math.max(f[max][0], f[max][1]);
    }


    public static int deleteAndEarn_HashMap(int[] nums) {

        if(nums == null){
            return 0;
        }

        int len = nums.length;

        HashMap<Integer,Integer>  hashMap = new HashMap<>();
        int maxNum = 0;

        for (int i = 0; i < len; i++) {
            hashMap.put(nums[i] , hashMap.getOrDefault(nums[i] , 0)+1);
            maxNum = Math.max(maxNum , nums[i]);
        }

        int[] dp = new int[maxNum+1];

        if(hashMap.containsKey(1)){
            dp[1] = hashMap.get(1);
        }else{
            dp[1] = 0;
        }

        for (int i = 2; i <= maxNum; i++) {
            if(hashMap.containsKey(i)){
                dp[i] = Math.max(dp[i-1] , dp[i-2] + i * hashMap.get(i));
            }else{
                dp[i] = dp[i-1];
            }

        }

        return dp[maxNum];

    }


}
