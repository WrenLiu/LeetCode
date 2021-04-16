

public class Solution {

    private static int res ;

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};

        System.out.println(jump(nums));


    }
    public static int jump(int[] nums) {

        if(nums == null || nums.length <= 1){
            return 0;
        }

        int curCount = 0;
        // 记录能到达的最远位置
        int maxLen = nums[0];
        int lastEnd = 0;

        for (int i = 0; i < nums.length; i++) {

            // 更新最远距离
            maxLen = Math.max(maxLen , i+nums[i]);


            // 已到最后一个位置
            if(maxLen >= nums.length-1){
                return curCount+1;
            }

            // 上次跳不到或者刚刚好能跳到现在的位置，就必须要步数+1了
            if(lastEnd <= i){
                lastEnd = maxLen;

                curCount++;
            }




        }

        return curCount;



    }





}
