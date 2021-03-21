

public class Solution {

    public static void main(String[] args) {

        int[] nums = {10};
        System.out.println(maxAscendingSum(nums));

    }

    public static int maxAscendingSum(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int leftIndex = 0,rightIndex = 0;

        int max = nums[0];
        int len = nums.length;

        while(rightIndex < len){

            while(rightIndex +1 < len && nums[rightIndex+1] > nums[rightIndex] ){
                rightIndex++;
            }

            int tmp = 0;
            for (int i = leftIndex; i <= rightIndex; i++) {
                tmp += nums[i];
            }

            max  = Math.max(tmp,max);

            leftIndex = rightIndex+1;
            rightIndex++;

        }

        return max;




    }



}
