

public class Solution {

    public static void main(String[] args) {

        int[] nums = {-1,1,-1,1,-1};
        System.out.println(arraySign(nums));


    }

    public static int arraySign(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }


        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                return 0;
            }

            if(nums[i] < 0){
                count ++;
            }

        }

        return count % 2 ==0 ? 1 : -1;




    }
}
