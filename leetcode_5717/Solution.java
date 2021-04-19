

public class Solution {

//    5717. 最少操作使数组递增
    public static void main(String[] args) {

        int[] nums = {1};
        System.out.println(minOperations(nums));


    }
    public static int minOperations(int[] nums) {

        if(nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }

        int count = 0;

        int base = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if(nums[i] <= base){
                count += base - nums[i] + 1;

                base = base + 1;
            }else{
                base = nums[i];
            }



        }




        return count ;

    }


}
