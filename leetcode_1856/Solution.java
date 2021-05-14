

import java.util.Arrays;
import java.util.Stack;

public class Solution {


    public static void main(String[] args) {
        int[] nums = {3,1,5,6,4,2};
        System.out.println(maxSumMinProduct(nums));

    }

    public static int maxSumMinProduct(int[] nums) {
        final int MODULO = 1000000007;

        if(nums == null){
            return 0;
        }

        long[] preSum = new long[nums.length+1];
        preSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }


        System.out.println(Arrays.toString(preSum));

        // 存的是索引
        Stack<Integer> stack = new Stack<>();

        int[] leftMinIndex = new int[nums.length];
        int[] rightMinIndex = new int[nums.length];
        Arrays.fill(rightMinIndex , nums.length-1);

        // 保持栈 从栈低到栈顶是递增的 ，nums[i]就是基准，当栈顶元素比基准大的时候，就弹出去，找到最低下的栈元素是恰好比基准大一丢丢的（就是边界了）
        for (int i = 0; i < nums.length; ++i) {
            while (!stack.empty() && nums[stack.peek()] >= nums[i]) {
                // 这里的 right 是非严格定义的，right[i] 是右侧最近的小于等于 nums[i] 的元素下标
                rightMinIndex[stack.peek()] = i - 1;
                stack.pop();
            }
            if (!stack.empty()) {
                // 这里的 left 是严格定义的，left[i] 是左侧最近的严格小于 nums[i] 的元素下标
                leftMinIndex[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        System.out.println(Arrays.toString(leftMinIndex));
        System.out.println(Arrays.toString(rightMinIndex));

        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res , nums[i] * (preSum[rightMinIndex[i]+1] - preSum[leftMinIndex[i]]) );
        }

        return (int)(res % MODULO);


    }


}
