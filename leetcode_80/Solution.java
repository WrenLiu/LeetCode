

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,1,2,3,3};
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

            if(leftIndex < 2 || nums[rightIndex ] != nums[leftIndex-2]){
                nums[leftIndex] = nums[rightIndex];
                leftIndex++;
            }

        }

        return leftIndex;


    }

    public static int removeDuplicates_Mine(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        final int bigNum = 100000;

        int res = 0;

        int leftIndex = 0 , rightIndex = 0;

        while (rightIndex < nums.length){

            while(rightIndex < nums.length && nums[rightIndex] == nums[leftIndex]){
                rightIndex++;
            }

            if(rightIndex - leftIndex > 2){
                leftIndex = leftIndex+2;

                while(leftIndex < rightIndex){
                    nums[leftIndex++] = bigNum;
                }

                res += 2;

            }else {
                res += rightIndex - leftIndex;

                leftIndex = rightIndex;
            }

        }

        leftIndex = 0;
        rightIndex = 0;

        while(leftIndex < nums.length && nums[leftIndex] != bigNum){
            leftIndex++;
        }
        rightIndex = leftIndex;
        while(rightIndex < nums.length && nums[rightIndex] == bigNum){
            rightIndex++;
        }

        while(rightIndex < nums.length){

            nums[leftIndex] = nums[rightIndex];
            leftIndex ++;
            rightIndex++;
            while(rightIndex < nums.length && nums[rightIndex] == bigNum){
                rightIndex ++;
            }

        }






        return res;


    }


}
