class Solution {
    public int majorityElement(int[] nums) {
        int number = nums[0];
        if(nums == null || nums.length<=0){
            return -1;
        }

        int cnt  = 1;

        // 这种方法建立在这个数组中最多的那个数是占到总数的1/2还要多的情况上
        // 所以定义一个信号量统计
        for (int i = 1; i < nums.length; i++) {
            if(cnt == 0){
                number = nums[i];
                cnt = 1;
            }else if(number == nums[i]){
                cnt++;
            }else{
                cnt--;
            }
        }

        return number;

    }
}