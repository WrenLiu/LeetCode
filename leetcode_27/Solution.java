
import javax.swing.plaf.IconUIResource;
import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {

        int[] nums = {3,2,2,3};
//        int[] nums = {2,3,3};


        int len = removeElement(nums,3);


        System.out.println("res: "+len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+" ");
        }


    }

    public static int removeElement_reserve(int[] nums, int val) {
        int idx = 0;
        for (int x : nums) {
            if (x != val) nums[idx++] = x;
            
        }
        
        return idx;
    }


    public static int removeElement(int[] nums,int val){

        if(nums == null || nums.length == 0){
            return 0;
        }


        int leftIndex = 0 , rightIndex = nums.length-1;

        for (; leftIndex <= rightIndex; leftIndex++) {

            if(nums[leftIndex] == val){
                int tmp = nums[leftIndex];
                nums[leftIndex] = nums[rightIndex];
                nums[rightIndex] = tmp;
                leftIndex--;
                rightIndex--;
            }


        }

        return rightIndex+1;



    }


    public static int removeElement_mine(int[] nums, int val) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int len = nums.length;
        int leftIndex = 0 ,rightIndex = nums.length-1;
        int count = 0;

        for (int num : nums) {
            count += num == val ? 1 : 0;
        }


        while(rightIndex >= 0 && nums[rightIndex] == val){
            rightIndex -- ;
        }

        if(rightIndex < 0){
            return len - count;
        }



        while(leftIndex < len - count && rightIndex >= 0){

            while(leftIndex < len - count && nums[leftIndex] != val){
                leftIndex++;
            }

            if(leftIndex == len - count){
                return len - count;
            }

            int tmp = nums[leftIndex];
            nums[leftIndex] = nums[rightIndex];
            nums[rightIndex] = tmp;

            while(rightIndex >= 0 && nums[rightIndex] == val){
                rightIndex -- ;
            }
        }

//        System.out.println(leftIndex);
//
//        System.out.println(Arrays.toString(nums));



        return len - count;





    }


}
