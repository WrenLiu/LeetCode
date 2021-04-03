

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
//        System.out.println(trap_01(height));

        System.out.println(trap_03(height));

    }

    // 超时
    private static int trap_01(int[] height){

        if(height == null){
            return -1;
        }

        int highest = 0;

        int maxHigh = getMax(height);

        int res = 0;

        for (int i = 1; i <= maxHigh; i++) {

            boolean isStart = false; //标记是否开始更新 temp

            int temp_sum = 0;

            for (int j = 0; j < height.length; j++) {

                if(isStart && height[j] < i) {
                    temp_sum++;
                }

                if(height[j] >= i){
                    res += temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }


        }

        return res;

    }

    private static int getMax(int[] height){

        int highest = 0;
        for (int i = 0; i < height.length; i++) {
            highest = Math.max(highest,height[i]);
        }

        return highest;
    }

    // 求每一列的水，我们只需要关注当前列，以及左边最高的墙，右边最高的墙就够了。
    // 装水的多少，当然根据木桶效应，我们只需要看左边最高的墙和右边最高的墙中较矮的一个就够了。
    // 时间复杂度 O(n^2)
    private static int trap_02(int[] height){

        int sum = 0;

        for (int i = 0; i < height.length; i++) {

            // i 表示当前列

            // 分别求左右两侧最高的墙的高度
            int leftMax = 0;
            for (int j = 0; j < i; j++) {

                leftMax = Math.max(leftMax,height[j]);
            }

            int rightMax = 0;
            for (int j = height.length-1; j > i ; j--) {

                rightMax = Math.max(rightMax , height[j]);
            }

            int minLeftAndRight = Math.min(leftMax,rightMax);

            if(minLeftAndRight - height[i] > 0 ){
                sum += minLeftAndRight - height[i];
            }


        }

        return sum;




    }

    // 因为每次都需要重新找左侧或者右侧最高的墙，所以可以用动态规划改进
    // 时间复杂度 O(3n) ,测试时间已经是100%
    private static int trap_03(int[] height){
        if(height == null || height.length == 0){
            return 0;
        }
        int sum = 0;


        int[] dp_leftMax = new int[height.length];
        int[] dp_rightMax = new int[height.length];

        dp_leftMax[0] = height[0];
        for (int i = 1; i < dp_leftMax.length; i++) {
            dp_leftMax[i] = Math.max(dp_leftMax[i-1] , height[i]);
        }

        dp_rightMax[dp_rightMax.length-1] = height[height.length-1];
        for (int i = height.length-2; i >= 0; i--) {
            dp_rightMax[i] = Math.max(dp_rightMax[i+1],height[i]);
        }


        for (int i = 0; i < height.length; i++) {

            int minLeftAndRight = Math.min(dp_leftMax[i],dp_rightMax[i]);

            if(minLeftAndRight - height[i] > 0 ){
                sum += minLeftAndRight - height[i];
            }


        }


        return sum;


    }


    // 用栈实现
    // 如果当前高度大于栈顶的墙的高度，说明之前的积水到这里停下，我们可以计算下有多少积水了。计算完，就把当前的墙继续入栈，作为新的积水的墙。
    // 总体的原则就是:
    // - 当前高度小于等于栈顶高度，入栈，指针后移。
    // - 当前高度大于栈顶高度，出栈，计算出当前墙和栈顶的墙之间水的多少，然后计算当前的高度和新栈的高度的关系，
    // 重复第 2 步。直到当前墙的高度不大于栈顶高度或者栈空，然后把当前墙入栈，指针后移。
    private static int trap_04(int[] height){        if(height == null || height.length == 0){
        return 0;
    }
        int sum = 0;

        Stack<Integer> stack = new Stack<>();

        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;

    }


    public static int trap(int[] height) {

        if(height == null){
            return -1;
        }

        int highest = 0;
        for (int i = 0; i < height.length; i++) {
            highest = Math.max(highest,height[i]);
        }

        int sum = 0;

        for (int i = 1; i <= highest; i++) {
            int leftIndex = 0;
            for (int j = 0; j < height.length; j++) {
                if(height[j] >= i){
                    leftIndex = j;
                    break;
                }
            }

            int rightIndex = height.length-1;
            for (int j = height.length-1; j >= leftIndex ; j--) {
                if(height[j] >= i){
                    rightIndex = j;
                    break;
                }
            }

            int volumeTotal = rightIndex - leftIndex + 1;

            int idleTotal = 0 ;

            for (int j = leftIndex; j < rightIndex; j++) {

                if(height[j] < i ){
                    idleTotal ++;
                }
            }

            sum += idleTotal;


//            System.out.println(volumeTotal+" "+idleTotal+" "+sum);

        }


        return sum;



    }


}

