/**
 * 只能由位置 i 的单独作为一个 item，设为 a，转移的前提是 a 的数值范围为 [1,9][1,9]，转移逻辑为 f[i] = f[i - 1]f[i]=f[i−1]。
 * 只能由位置 i 的与前一位置（i-1）共同作为一个 item，设为 b，转移的前提是 b 的数值范围为 [10,26][10,26]，转移逻辑为 f[i] = f[i - 2]f[i]=f[i−2]。
 * 位置 i 既能作为独立 item 也能与上一位置形成 item，转移逻辑为 f[i] = f[i - 1] + f[i - 2]f[i]=f[i−1]+f[i−2]。
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(numDecodings("226"));
    }

    public static int numDecodings(String s) {

        if(s == null || s.length() == 0 || s.startsWith("0")){
            return 0;
        }

        s = '0'+s;
        int len = s.length();
        int[] dp = new int[len];

        dp[0] = 1;
        int index = 1;
        int cur = 0;
        int preCur = 0;


        while(index < len){

            cur =  s.charAt(index) - '0';
            preCur = (s.charAt(index-1) - '0') * 10 + cur;

            if(cur <= 9 && cur >= 1){
                dp[index] = dp[index-1];
            }

            if(index >= 2 && preCur <= 26 && preCur >= 10){
                dp[index] += dp[index-2];
            }

            index++;
        }
        
        return dp[dp.length-1];




    }


}
