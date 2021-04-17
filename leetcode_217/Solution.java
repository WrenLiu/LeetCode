
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));

    }

    public static boolean containsDuplicate(int[] nums) {

        if(nums == null){
            return false;
        }

        HashSet<Integer> hashSet = new HashSet<>();


        for (int i = 0; i < nums.length; i++) {
            if(hashSet.contains(nums[i])){
                return true;
            }else{
                hashSet.add(nums[i]);
            }


        }


        return false;

    }


}
