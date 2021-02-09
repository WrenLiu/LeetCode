import java.util.*;

public class Solution {


    public static void main(String[] args) {

        int[] nums = {1,2,1,3,4};

        System.out.println(subarraysWithKDistinct(nums,3));
    }

    public static int subarraysWithKDistinct(int[] A, int K) {

        if(A == null || K<= 0){
            return -1;
        }

        int total = 0;

        return helper(A,K) - helper(A,K-1);



    }

    private static int helper(int[] nums  , int k){

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        int left = 0 ,right = 0;
        int totalN = 0;

        while(right < nums.length){

            if (hashMap.containsKey(nums[right])) {
                hashMap.put(nums[right], hashMap.get(nums[right]) + 1);
            } else {
                hashMap.put(nums[right], 1);
            }
            right ++;


            while(hashMap.size() > k){

                hashMap.put(nums[left],hashMap.get(nums[left])-1);
                if(hashMap.get(nums[left]) == 0) hashMap.remove(nums[left]);

                left ++;
            }
            totalN += right - left;

        }

        return totalN;


    }

}
