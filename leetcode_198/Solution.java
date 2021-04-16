
public class Solution {

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};

        System.out.println(rob(nums));


    }

    public static int rob(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }

        int[] maxMoney = new int[nums.length];

        maxMoney[0] = nums[0];
        maxMoney[1] = Math.max(nums[0],nums[1]);

        for (int i = 2; i < nums.length; i++) {

            maxMoney[i] = Math.max(nums[i] + maxMoney[i-2] , maxMoney[i-1]);

        }

        return maxMoney[nums.length-1];






    }



}
