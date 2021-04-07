

public class Solution {


    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};

        System.out.println(search(nums,0));

    }

    public static int search(int[] nums, int target) {

        if(nums == null){
            return -1;
        }

        int leftIndex = 0, rightIndex = nums.length-1;

        while(leftIndex <= rightIndex){

            int mid = (leftIndex + rightIndex) >> 1;

            if(nums[mid] == target){
                return mid;
            }else if(nums[rightIndex] < nums[leftIndex]){
                if(nums[mid] <= nums[rightIndex]){

                    if(target > nums[mid] && target <= nums[rightIndex]){
                        leftIndex = mid +1 ;
                        continue;
                    }else{
                        rightIndex = mid - 1;
                        continue;
                    }
                }else{
                    if(target < nums[mid] && target >= nums[leftIndex]){

                        rightIndex = mid - 1;
                    }else{

                        leftIndex = mid + 1;
                    }

                }
            }else{
                return helper(nums,leftIndex , rightIndex , target);
            }



        }








        return -1;
    }

    private static int helper(int[] nums, int leftIndex , int rightIndex , int target){

        int mid = leftIndex;
        while(leftIndex <= rightIndex){

            mid = (leftIndex + rightIndex) >> 1;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){

                leftIndex = mid + 1;
            }else{
                rightIndex = mid - 1;
            }
        }

        return -1;


    }
}
