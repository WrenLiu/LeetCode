public class Solution {

    public static void main(String[] args) {

        int[] nums1 = {30,29,19,5};
        int[] nums2 = {25,25,25,25,25};


        System.out.println(maxDistance_mine(nums1,nums2));


    }


    public static int maxDistance_mine(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null){
            return 0;
        }

        int index01 = 0,index02 = 0;
        int maxLen = 0;
        for (index01 = 0; index01 < nums1.length; index01++) {

            for (index02 = index01 + maxLen; index02 < nums2.length; index02++) {

                if(nums2[index02] >= nums1[index01]){
                    maxLen = Math.max(maxLen , index02 - index01);
                }

                if(nums2[index02] < nums1[index01]){
                    break;
                }
            }


        }

        return maxLen;




    }


}
