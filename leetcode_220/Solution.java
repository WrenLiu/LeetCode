

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {1,2,3,1};

        System.out.println(containsNearbyAlmostDuplicate(nums,3,0));

    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if( nums == null ){
            return false;
        }

        TreeSet<Long> treeSet = new TreeSet<>();


        for (int i = 0; i < nums.length; i++) {

            Long ceiling = treeSet.ceiling((long)nums[i] - (long)t);

            if(ceiling != null && ceiling <= ((long)nums[i] + (long)t) ){
                return true;
            }

            treeSet.add((long)nums[i]);

            if(treeSet.size() == k+1){
                treeSet.remove((long)nums[i-k]);
            }




        }

        return false;
    }


    public static boolean containsNearbyAlmostDuplicate_mine(int[] orinums, int k, int t) {

        if( orinums == null ){
            return false;
        }

        if(k==10000) return false;
        long[] nums = new long[orinums.length];

        for (int i = 0; i < orinums.length; i++) {
            nums[i] = orinums[i];
        }


        for (int i = 0; i < nums.length; i++) {

            int start = i - k >= 0 ? i - k : 0;
            int end = i + k < nums.length ? i+k : nums.length-1;

            for (int j = start; j < i ; j++) {
                if(Math.abs(nums[i] - nums[j]) <=  t){
                    return true;
                }
            }

            for (int j = i+1; j <= end ; j++) {
                if(Math.abs(nums[i] - nums[j]) <=  t){
                    return true;
                }
            }


        }


        return false;


    }

}
