

public class Solution {

    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};

//        int[] nums = {1,3};

        System.out.println(search(nums,7));


    }

    public static boolean search(int[] nums, int target) {

        if(nums == null){
            return false;
        }

        int leftIndex = 0,rightIndex = nums.length-1;
        
        if(nums[rightIndex] == target){
            return true;
        }

        while(rightIndex >= 0 && nums[rightIndex] == nums[nums.length-1]){
            rightIndex--;
        }


        // 此时rightIndex的数一定小于左侧的值
        while(leftIndex <= rightIndex){

            int mid = (leftIndex + rightIndex) >> 1;

            // 区间是闪电型
            if(nums[mid] ==  target){
                return true;
            }else if(nums[rightIndex] < nums[leftIndex]){
                System.out.println("shandian");
                System.out.println(leftIndex+" "+rightIndex+" "+nums[leftIndex]+" "+nums[rightIndex]);
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
                System.out.println("helper");
                return helper(nums,leftIndex,rightIndex,target);
            }

        }

        return false;
    }

    private static boolean helper(int[] nums,int leftIndex,int rightIndex,int target){

        int leftNum = nums[leftIndex] ,rightNum = nums[rightIndex];

        System.out.println(leftIndex+" "+rightIndex);
        while(leftIndex <= rightIndex){

            int mid = (leftIndex + rightIndex) /2 ;
            System.out.println(leftIndex+" "+rightIndex);
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] < target){
                leftIndex = mid + 1;
                leftNum = nums[mid];
            }else{
                rightIndex = mid - 1;
                rightNum = nums[mid];
            }

        }

        return target == leftNum || target == rightNum;

    }



}
