
import java.util.HashMap;
import java.util.Map;

public class Solution {


    public static void main(String[] args) {

        int[] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(numSubarraysWithSum_leetcode(nums , goal));
        System.out.println(numSubarraysWithSum(nums , goal));

    }

    public static int numSubarraysWithSum_leetcode(int[] nums , int goal){

        HashMap<Integer , Integer> count = new HashMap<>();

        int res = 0;

        int sum = 0;
        for (int num : nums) {

            count.put(sum , count.getOrDefault(sum , 0)+1);
            sum += num;

            // 并没有在哈希表中加入
            res += count.getOrDefault(sum - goal, 0);

            

        }

        return res;

    }



    public static int numSubarraysWithSum(int[] nums, int goal) {

        if(nums == null || goal < 0 ){
            return 0;
        }

        int[] arr = new int[nums.length+2];
        for (int i = 0; i < nums.length; i++) {
            arr[i+1] = nums[i] + arr[i];
        }

//        System.out.println(Arrays.toString(arr));
        int res = 0;
        int len = nums.length;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {


                if(arr[right+1] - arr[left] == goal){
//                    System.out.println(left+" "+right);
                    res++;
                }else if(arr[right+1] - arr[left] > goal){
                    break;
                }



            }


        }


        return res;


    }
}
