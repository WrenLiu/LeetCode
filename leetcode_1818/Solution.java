import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] num1 = {1,10,4,4,2,7};
        int[] num2 = {9,3,5,1,7,4};
        System.out.println(minAbsoluteSumDiff(num1,num2));

    }

    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null || nums1.length != nums2.length){
            return 0;
        }

        int len = nums1.length;

        long sum = 0;

        int[] arr1 = Arrays.copyOf(nums1,len);
        Arrays.sort(arr1);

        for (int i = 0; i < len; i++) {
            sum += Math.abs(nums1[i] - nums2[i]);
        }

        if(sum == 0){
            return 0;
        }

        // 求 max, 用max存储 Max(abs(ai-ci)-abs(ai-bi))(
        //
        int max = 0;
        for (int i = 0; i < len; i++) {

            max = Math.max(max , Math.abs(nums1[i] -nums2[i]) - helper(arr1,nums2[i]));

        }

        // sum 减去 max

        return (int)((sum-max) %1000000007);
    }

    // 返回arr[i] - nums2 的差值最小的结果
    private static int helper(int[] arr , int nums2){

        int left = 0 , right = arr.length -1;
        int mid = 0;
        int leftNum = 0 ,rightNum = 0;


        while(left <= right){

            mid = (right + left) / 2;
            if(arr[mid] == nums2){

                return 0;
            }else if(arr[mid] < nums2){

                left = mid + 1;
                leftNum = arr[mid];

            }else{
                right = mid - 1;
                rightNum = arr[mid];
            }

        }

        return Math.min(Math.abs(leftNum - nums2),Math.abs(rightNum- nums2));


    }


}
