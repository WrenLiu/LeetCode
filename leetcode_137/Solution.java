import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {30000,500,100,30000,100,30000,100};
        System.out.println(singleNumber_leetcode02(nums));

    }

    public static int singleNumber_leetcode02(int[] nums) {
        if(nums == null){
            return -1;
        }

        int one = 0 , two = 0;

        for(int x : nums){
            one = one ^ x & ~two;
            two = two ^ x & ~one;
        }
        return one;


    }


    public static int singleNumber_leetcode01(int[] nums) {

        if(nums == null){
            return -1;
        }

        int[] cnt = new int[32];

        for (int num : nums) {

            for (int i = 0; i < 32; i++) {
                cnt[i] += num  & 1;
                num >>= 1;
            }
        }

        // 重新 mod 3 拼凑出只有1位的
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((cnt[i] % 3 & 1) == 1) {
                ans += (1 << i);
            }
        }
        return ans;

    }

    public static int singleNumber_mine(int[] nums) {

        if(nums == null){
            return -1;
        }

        Arrays.sort(nums);

        int index = 0;
        while(index < nums.length){

            int tmp = nums[index];
            int endIndex = index + 2;

            if(endIndex >= nums.length){
                return tmp;
            }

            if(tmp == nums[index+1] && tmp == nums[endIndex]){
                index += 3;
            }else{
                return tmp;
            }
        }


        return 0;



    }



}
