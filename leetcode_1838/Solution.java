
import java.util.Arrays;
import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {

        int[] nums = {1,4,8,13};

        System.out.println(maxFrequency_leetcode(nums,5));

    }


    public static int maxFrequency_leetcode(int[] nums, int k){


        if(nums == null ){
            return 0;
        }

        Arrays.sort(nums);

        int leftIndex = 0, rightIndex = 1;

        int len = nums.length;

        int res = 1;
        int total = 0;


        while(rightIndex < len){
            total += (nums[rightIndex] - nums[rightIndex - 1])*(rightIndex - leftIndex);

            while (total > k){
                total -= nums[rightIndex] - nums[leftIndex];
                leftIndex++;
            }

            res = Math.max(res , rightIndex - leftIndex + 1);
            rightIndex++;

        }

        return res;

    }

}
