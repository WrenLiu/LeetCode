
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution{

    public static void main(String[] args) {

        int[] nums = {0,1,0,3,0,4,0,4,0};
        int k = 5;

        System.out.println(checkSubarraySum(nums,k));

    }

    public static boolean checkSubarraySum(int[] nums, int k) {

        if(nums.length < 2) return false;

        int[] preSum = new int[nums.length];

        preSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i-1] + nums[i];
        }



        if(k == 0) return false;
        if(k < 0) k = -k;


//        当 preSum[q]-preSum[p] 为 k 的倍数时，preSum[p] 和 preSum[q] 除以 k 的余数相同。
//        因此只需要计算每个下标对应的前缀和除以 k 的余数即可，使用哈希表存储每个余数第一次出现的下标。

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,-1);



        for (int i = 0; i < preSum.length; i++) {

            int mod = preSum[i] % k;
            if(mod == 0 && i > 1) {
                return true;
            }

            if(hashMap.containsKey(mod)){
                int left = hashMap.get(mod);
                if(i - left > 1){
                    return true;
                }


            }else{
                hashMap.put(mod, i);
            }


        }


        return false;


    }



}
