

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);

        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+" ");
        }

    }

    private static int removeDuplicates(int[] nums){

        if(nums == null || nums.length == 0){
            return 0;
        }

        int leftIndex = 0 , rightIndex = 0;



        for (rightIndex = 0; rightIndex < nums.length; rightIndex++) {

            if(leftIndex < 1 || nums[rightIndex ] != nums[leftIndex-1]){
                nums[leftIndex] = nums[rightIndex];
                leftIndex++;
            }

        }

        return leftIndex;


    }



}
