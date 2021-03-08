

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        String s = "ab";
        System.out.println(minCut(s));

    }

    public static int minCut(String s) {

        if(s == null || s.length() <= 1){
            return 0;
        }

        int len = s.length();

        // 预处理阶段，可将复杂度降到O(n^2)
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int right = 0; right < len; right++) {
            for (int left = right; left >= 0  ; left--) {

                // left == right : 意味着此时只有一个字符 e.g "a"
                if(left == right){
                    isPalindrome[left][right] = true;

                    // right - left + 1 == 2 : 意味着只有两个相邻字符，此时肯定是回文字符串 ，e.g "ab"就不是回文 "aa"就是回文
                }else if(right - left + 1 == 2 && s.charAt(left) == s.charAt(right)){
                    isPalindrome[left][right] = true;

                    // 此时意味着left和right中间夹着的字符串是回文，且left和right的位置上的字符是相同的，则肯定是回文 e.g "a aba a"
                }else if(isPalindrome[left+1][right-1] && (s.charAt(left) == s.charAt(right))){
                    isPalindrome[left][right] = true;
                }

            }


        }


        for (boolean[] booleans : isPalindrome) {
            System.out.println(Arrays.toString(booleans));
        }


        // 状态定义dp(i)我认为应该是[0:i]闭区间上需要分割的最小次数
        int[] dp = new int[len];

        for (int right = 1; right < len; right++) {

            // 从0到right位置的这个字符串 是回文串,即不用切割
            if(isPalindrome[0][right]){
                dp[right] = 0;
            }else{

                // 不满足上面的条件就进行一次切割
                dp[right] = dp[right-1] + 1;

                for (int left = 1; left < right; left++) {
                    if(isPalindrome[left][right]){
                        dp[right] = Math.min(dp[right],dp[left-1]+1);
                    }
                }

            }

        }


        return dp[len-1];

    }
    

}
