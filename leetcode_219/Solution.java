
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {1,2,3,1,2,3};

        System.out.println(containsNearbyDuplicate(nums,2));

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        if(nums == null || k == 0){
            return false;
        }

        TreeSet<Integer> leftSet = new TreeSet<>();
        TreeSet<Integer> rightSet = new TreeSet<>();

        k = k+1;

        for (int i = 1; i < k && i < nums.length; i++) {
            if(rightSet.contains(nums[i])){
                return true;
            }else{
                rightSet.add(nums[i]);
            }
        }



        for (int i = 0; i < nums.length; i++) {

            if(rightSet.contains(nums[i]) || leftSet.contains(nums[i])){
                return true;
            }

            leftSet.add(nums[i]);

            if(i-k+1 >= 0){
                leftSet.remove(nums[i-k+1]);
            }

            if(i+1 < nums.length){
                rightSet.remove(nums[i+1]);
            }

            if(i+k <nums.length){
                rightSet.add(nums[i+k]);
            }


        }


        
        
        
        
        return false;

        

    }


}
