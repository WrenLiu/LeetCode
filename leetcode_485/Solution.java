

public class Solution {

    public static void main(String[] args) {

//        int[] nums = {1,1,0,1,1,1};
        int[] nums01 = {0};
        System.out.println(findMaxConsecutiveOnes(nums01));

    }

    public static int findMaxConsecutiveOnes(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }


        int left = 0,right = 0;
        int max = 0;


        while(right < nums.length && left < nums.length){

            if(nums[left] != 1){
                left ++;
                continue;
            }

            right = left;

            while(right < nums.length && nums[right] != 0){


                right ++;
            }

            max = Math.max(right-left,max);
            left = right;

        }

        return max;




    }


}
