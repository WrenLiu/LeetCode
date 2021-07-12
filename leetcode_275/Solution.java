
public class Solution {

    public static void main(String[] args) {

        int[] citations = {0,1};
        System.out.println(hIndex(citations));
    }

    public static int hIndex(int[] nums) {

        int res = 0;
        int len = nums.length;

        int leftIndex = 0 , rightIndex = len - 1;
        while(leftIndex <= rightIndex){

            int mid = (rightIndex - leftIndex) / 2  + leftIndex;

            int h = len - mid;

            // h 逐渐变小才是正常的，因为过大的h不一定满足要求
            if(h <= nums[mid]){
                res = h;
                rightIndex = mid - 1;
                
            }else {
                leftIndex = mid + 1;
            }
        }



        return res;

    }


}
