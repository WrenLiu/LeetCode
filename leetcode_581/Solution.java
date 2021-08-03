

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

//        int[] nums = {1,3,3,2,2,3,3};

        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray_leetcode(nums));

    }

    // O(n)
    public static int findUnsortedSubarray_leetcode(int[] nums) {

        final int MIN = -100005, MAX = 100005;
        if(nums == null || nums.length <= 1){
            return 0;
        }

        int len = nums.length;

        int left = 0 , right = len-1;
        while(left < right && nums[left] <= nums[left+1]) left++;
        while(left < right && nums[right-1] <= nums[right]) right--;

        int min = nums[left] , max = nums[right];

        int indexLeft = left , indexRight = right;

        for (int i = left; i <= right ; i++) {
            if(nums[i] < min){
                while(indexLeft >= 0 && nums[indexLeft] > nums[i]) indexLeft--;
                min = indexLeft >= 0 ? nums[indexLeft] : MIN;
            }

            if(nums[i] > max){
                while(indexRight < len && nums[indexRight] < nums[i]) indexRight++;
                max = indexRight< len ? nums[indexRight] : MAX;

            }


        }





        return indexLeft == indexRight ? 0 : indexRight - indexLeft -1;

    }


    // O(n * log(n))
    public static int findUnsortedSubarray(int[] nums) {

        if(nums == null || nums.length <= 1){
            return 0;
        }

        int[] arr = Arrays.copyOf(nums,nums.length);

        Arrays.sort(arr);
        int leftIndex = 0;
        int len = nums.length;
        while(leftIndex < len && arr[leftIndex] == nums[leftIndex]){
            leftIndex++;
        }

        int rightIndex = len-1;
        while(rightIndex >= 0 && arr[rightIndex] == nums[rightIndex]){
            rightIndex--;
        }

        if(rightIndex > leftIndex){
            return rightIndex - leftIndex +1;
        }else{
            return 0;
        }


    }



}
