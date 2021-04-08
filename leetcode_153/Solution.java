

public class Solution{

    public static void main(String[] args) {

        int[] nums = {3,4,5,1,2};

        System.out.println(findMin(nums));

    }

    public static int findMin(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int leftIndex = 0, rightIndex = nums.length-1;

        if(nums[rightIndex] >= nums[leftIndex]){
            return nums[leftIndex];
        }

        int minNum = nums[rightIndex];

        while(leftIndex <= rightIndex){


            int mid = (leftIndex + rightIndex) >> 1;

//            System.out.println(leftIndex + " "+ rightIndex +" "+nums[leftIndex] +" "+nums[rightIndex]);

            if(nums[mid] <= nums[leftIndex] && nums[mid] <= nums[rightIndex]){
                minNum = Math.min(minNum , nums[mid]);
                rightIndex = mid - 1;
            }else if(nums[leftIndex] <= nums[mid] && nums[leftIndex] >= nums[rightIndex]){
                minNum = Math.min(minNum, nums[leftIndex]);
                leftIndex = mid + 1;
            }else {
                Math.min(minNum, nums[mid]);
                rightIndex = mid - 1;

            }


        }

        return Math.min(minNum , nums[leftIndex]);








    }


}
