class Solution {
    public int arrayPairSum(int[] nums) {

        if(nums == null || nums.length == 1){
            return 0;
        }

        Arrays.sort(nums);

        int total = 0;
        for(int i =0;i<nums.length;i+=2){
            total += nums[i];
        }
        return total;
        



    }
}