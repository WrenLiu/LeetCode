

import java.util.LinkedList;
import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

        int[] nums = {915,444,500};

//        int[] nums = {1,2,3};
        System.out.println(canBeIncreasing(nums));


    }
    public static boolean canBeIncreasing_mine(int[] nums) {

        if(nums == null){
            return true;
        }




        boolean flag = isAdd(nums);

        for (int i = 0; i < nums.length; i++) {

            int[] newArr = new int[nums.length-1];
            int index = 0 ;
            for (int j = 0; j < i; j++) {
                newArr[index++] = nums[j];
            }

            for (int j = i+1; j < nums.length; j++) {
                newArr[index++] = nums[j];
            }

            if(isAdd(newArr)){
                flag = true;
            }

        }


        return flag;





    }

    private static boolean isAdd(int[] nums ){

        int preIndex = 0 , curIndex = 1;
        while(curIndex < nums.length && nums[curIndex] > nums[preIndex]){
            preIndex++;
            curIndex++;
        }

        return curIndex == nums.length;

    }

    public static boolean canBeIncreasing(int[] nums) {

        if(nums.length <= 2) return true;

        // 左到右一次单调递增栈，右到左一次递减栈

        Stack<Integer> stack = new Stack<>();

        int len = nums.length;


        stack.push(nums[0]);


//        int[] nums = {1,2,10,5,7};
        int leftIndex = 1;
        while(!stack.isEmpty() && leftIndex < len && nums[leftIndex] > stack.peek()){
            stack.push(nums[leftIndex]);
            leftIndex++;
        }

        if(leftIndex == len)  return true;
        leftIndex --;

        stack.clear();
        int rightIndex = len-2;
        stack.push(nums[len-1 ]);

        while(!stack.isEmpty() && rightIndex >= 0 && nums[rightIndex] < stack.peek()){
            stack.push(nums[rightIndex]);
            rightIndex -- ;
        }

        rightIndex++;


        System.out.println(leftIndex +" "+rightIndex);


        boolean flag01 = false;
        boolean flag02 = false;
        boolean flag03 = false;
        boolean flag04 = false;

        if(leftIndex > 0 ){
            flag01 =  rightIndex - leftIndex < 2 && (nums[rightIndex] > nums[leftIndex - 1]) ;

        }

        if(rightIndex < len-1){
            flag02 = rightIndex - leftIndex < 2 && (nums[rightIndex+1] > nums[leftIndex]) ;
        }

        if(leftIndex == 0){
            flag03 = rightIndex - leftIndex < 2;
        }

        if(rightIndex == len-1){
            flag04 = rightIndex - leftIndex < 2;
        }


        return flag01 || flag02 || flag03 || flag04;


    }

}
