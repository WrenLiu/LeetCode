

public class Solution {

    public static void main(String[] args) {


        int[] nums = {4, 14, 2};

        System.out.println(totalHammingDistance(nums));

        System.out.println(totalHammingDistance_leetcode(nums));

    }

//    若长度为 n 的数组 nums 的所有元素二进制的第 i 位共有 c 个 1，n-c 个 0，
//    则些元素在二进制的第 i 位上的汉明距离之和为 c⋅(n−c)

    public static int totalHammingDistance_leetcode(int[] nums) {
        if(nums == null){
            return 0;
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {

            int c = 0;
            for (int j = 0; j < nums.length; j++) {
                c += nums[j] >> i & 1;
            }

            res += c * (nums.length - c);

        }

        return res;



    }


    public static int totalHammingDistance(int[] nums) {


        if(nums == null){
            return 0;
        }

        int res = 0;
        for (int i = 0; i < nums.length-1; i++) {

            for (int j = i+1; j < nums.length; j++) {
                res += helper(nums[i] , nums[j]);
            }
        }

        return res;



    }

    private static int helper(int x, int y) {


        int z = x ^ y;
        z = (z & 0x55555555) + ((z >> 1) & 0x55555555);
        z = (z & 0x33333333) + ((z >> 2) & 0x33333333);
        z = (z & 0x0f0f0f0f) + ((z >> 4) & 0x0f0f0f0f);
        z = (z & 0x00ff00ff) + ((z >> 8) & 0x00ff00ff);
        z = (z & 0x0000ffff) + ((z >> 16) & 0x0000ffff);
        return z;
    }



}
