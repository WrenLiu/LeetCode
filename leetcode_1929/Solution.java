public class Solution {

    public static void main(String[] args) {


        int[] nums = {0,1,2};
        getConcatenation(nums);

    }
    public static int[] getConcatenation(int[] nums) {

        if(nums == null){
            return null;
        }

        int len = nums.length;

        int[] res = new int[len * 2];
        for(int i = 0 ; i < len ;i++){
            res[i] = nums[i];
            res[len + i ] = nums[i];
        }

        return res;



    }

}