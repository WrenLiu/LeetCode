
import java.util.Arrays;
import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {

        int[] nums = {0,1,1};

        System.out.println(findMaxLength(nums));

    }

    public static int findMaxLength(int[] nums) {

        if(nums == null){
            return 0;
        }

        int len = nums.length;
        int res = 0;

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        hashMap.put(0,-1);

        int count = 0;

        for (int i = 0; i < len; i++) {

            count += nums[i] == 0 ? -1 : 1;

            if(hashMap.containsKey(count)){
                // 哈希表中有count,意味着这个 i 位置上的总和 和 之前的preIndex位置上的总和是相同的,两者相减必得 0 
                int preIndex = hashMap.get(count);
                res = Math.max(res , i - preIndex);
            }else{
                hashMap.put(count , i);
            }


        }

        return res;

    }

}
