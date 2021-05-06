public class Solution {


    public static void main(String[] args) {

        int[] nums = {1,1,1,1,1,1,1,1,1,1};

        System.out.println(getMinDistance(nums,1,0));


    }

    public static int getMinDistance(int[] nums, int target, int start) {

        if(nums == null){
            return 0;
        }

        int minCha = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                minCha = Math.min(minCha,  Math.abs(start - i));
            }
        }

        return minCha;

    }

}
