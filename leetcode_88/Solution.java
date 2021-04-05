

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        merge(nums1,3,nums2,3);



//        int[] nums1 = {2,0};
//        int[] nums2 = {1};
//
//        merge(nums1,1,nums2,1);


        System.out.println(Arrays.toString(nums1));

        
    }

    public static void merge_Leetcode(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2 == null || n == 0){
            return;
        }

        if( m == 0){
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
        }

        int index01 = m-1,index02 = n-1;
        int indexTotal = m+n-1;




        while(index01 >= 0 && index02 >= 0){

            while(index01 >= 0 && index02 >= 0 && nums1[index01] >= nums2[index02]){
                nums1[indexTotal--] = nums1[index01];
                index01--;
            }

            while(index01 >= 0 && index02 >= 0 && nums1[index01] <= nums2[index02]){
                nums1[indexTotal--] = nums2[index02];
                index02--;
            }

        }

        while(indexTotal != -1 && index02 != -1){
            nums1[indexTotal--] = nums2[index02];
            index02--;
        }






    }
    public static void merge_Mine(int[] nums1, int m, int[] nums2, int n) {

        if(nums2 == null || nums2.length == 0){
            return;
        }

        if(nums1 == null || nums1.length == 0){
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
        }

        for (int i = 0; i < n; i++) {
            nums1[i+m] = nums2[i];
        }

        Arrays.sort(nums1);

        return ;
    }


}
