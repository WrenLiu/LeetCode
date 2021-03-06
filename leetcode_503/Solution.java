import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {


        int[] nums = {1};

        System.out.println(Arrays.toString(nextGreaterElements(nums)));

    }

    public static int[] nextGreaterElements(int[] nums) {

        if(nums == null ){
            return null;
        }

        int[] res = new int[nums.length];

        if(nums.length == 0){
            return res;
        }
        Arrays.fill(res,-1);

        Stack<Integer> stack = new Stack<>();

        int indexArr = 0;

        // 单调栈实现
        for (; indexArr < 2*nums.length; indexArr++) {
            int tmpNum = nums[indexArr % nums.length];

            while(!stack.isEmpty() && nums[stack.peek()] < tmpNum ){
                res[stack.pop()] = tmpNum;
            }

            if(indexArr < nums.length){
                stack.push(indexArr);
            }




        }







        return res;




    }


}
