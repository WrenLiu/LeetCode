
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {

    private BigInteger res;

    public static void main(String[] args) {

        int[] nums = {7,7,7,7,7,7,7};

        System.out.println(sumOfFlooredPairs_leetcode(nums));


    }

    public static int sumOfFlooredPairs_leetcode(int[] nums) {
        int N = 100000;
        int[] count = new int[N+1];
        for (int num : nums) {
            count[num]++;
        }
        int[] preSum = new int[N+2];
        for (int i = 0; i <= N; i++) {
            preSum[i + 1] = preSum[i] + count[i];
        }
        long result = 0;
        int mod = 1000000007;
        for (int num = 1; num <= N; num++) {
            if (count[num] == 0) {
                continue;
            }
            for (int i = 1; i * num <= N; i++) {
                int left = i * num;
                // PreSum的index最大取到N + 1
                int right = Math.min(N + 1, (i + 1) * num);
                // 数有多少个数在[num * i, num * (i + 1) - 1]，这些数除以num都等于i
                result += count[num] * (preSum[right] - preSum[left]) * i;
                result %= mod;
            }
        }
        return (int)result;
    }
    



}
