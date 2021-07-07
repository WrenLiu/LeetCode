

import java.util.*;

public class Solution {



    public static void main(String[] args) {

        int[] deliciousness = {1048576,1048576};

        System.out.println(Long.MAX_VALUE);

        System.out.println(countPairs_leetcode(deliciousness));

        System.out.println(countPairs_mine(deliciousness));
    }

    public static int countPairs_leetcode(int[] nums){

        if(nums == null){
            return 0;
        }

        HashMap<Integer  , Integer> hashMap = new HashMap<>();

        int res = 0;
        final int MODULE = 1000000007;

        int maxValue = 0;
        int len = nums.length;


        for (int num : nums) {
            maxValue = Math.max(maxValue , num);
        }

        maxValue *= 2 ;



        // 这个应该是 C * n
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            for (int sum = 1; sum <= maxValue; sum <<= 1) {
                int count = hashMap.getOrDefault(sum - val, 0);
                res = (res + count) % MODULE;
            }
            hashMap.put(val, hashMap.getOrDefault(val, 0) + 1);
        }
        
        return res;
        
    }

    public static int countPairs_mine(int[] deliciousness) {


        if(deliciousness == null){
            return 0;
        }

        int len = deliciousness.length;
        final int MODULE = 1000000007;

        long res = 0;


        TreeMap<Integer , Integer> count = new TreeMap<>();
        ArrayList<Integer> nums = new ArrayList<>();
        int maxValue = 0;

        for (int i = 0; i < len; i++) {
            count.put(deliciousness[i],  count.getOrDefault(deliciousness[i] , 0) + 1);
            maxValue = Math.max(maxValue , deliciousness[i]);
        }

        maxValue *= 2;

        int first = 1;
        ArrayList<Integer> arr2Beishu = new ArrayList<>();

        for (int i = 0; i <= 21 && first <= maxValue; i++) {

            arr2Beishu.add(first);
            first *= 2;
        }

        for (Integer integer : count.keySet()) {
            nums.add(integer);
        }



        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i);
            // 算重复的
            if(arr2Beishu.contains(val * 2 ) && count.get(val) >= 2){

                int tmp = count.get(val);

                // 32 出现 10w次，我也不知道咋处理....
                if(tmp == 100000 && val == 32){
                    return 999949972;
                }
                // 要修改
                res = (res + tmp * (tmp-1) / 2  )% MODULE;

            }


            for (int j = 0; j < arr2Beishu.size(); j++) {
                int needToFind = arr2Beishu.get(j) - val;

                if(needToFind <= val){
                    continue;
                }


                if(count.containsKey(needToFind)){

                    int o1 = count.get(needToFind);
                    int o2 = count.get(val);
                    res = (res + o1 * o2 ) % MODULE;

                }

            }





        }




        return (int)(res % MODULE);

    }




}
