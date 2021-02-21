import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {1,5,6,7,8,10,6,5,6};
        int[] nums_02 = {10,1,2,4,7,2}; // 5

        // TreeMap 实现
//        System.out.println(longestSubarray_TreeMap(nums,4));
        System.out.println(longestSubarray_PriorityQueue(nums_02,5));
    }

    public static int longestSubarray_PriorityQueue(int[] nums, int limit) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        PriorityQueue<Integer> maxDeque = new PriorityQueue<Integer>((o1, o2) -> o2-o1);
        PriorityQueue<Integer> minDeque = new PriorityQueue<Integer>((o1, o2) -> o1-o2);

        int left = 0,right = 0;
        int maxLen = 0;
        while(right < nums.length){

            maxDeque.add(nums[right]);
            minDeque.add(nums[right]);

            while (maxDeque.peek() - minDeque.peek() > limit){

                if(maxDeque.contains(nums[left])){
                    maxDeque.remove(nums[left]);
                }
                if(minDeque.contains(nums[left])){
                    minDeque.remove(nums[left]);
                }

                left++;


            }

            System.out.println(left+" "+right+" "+maxLen);
            maxLen = Math.max(maxLen,right-left+1);
            right ++;



        }


        return maxLen;



    }

    public static int longestSubarray_TreeMap(int[] nums, int limit) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int left = 0,right = 0;
        int maxLen = 0, maxAbs = 0;

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();


        while(right < nums.length){

            treeMap.put(nums[right] ,treeMap.getOrDefault(nums[right],0)+1);

            while(left < right && Math.abs(treeMap.firstKey() - treeMap.lastKey()) > limit){

                treeMap.put(nums[left],treeMap.get(nums[left])-1);
                if(treeMap.get(nums[left]) == 0){
                    treeMap.remove(nums[left]);
                }

                left++;

            }

            maxLen = Math.max(maxLen,right-left+1);
            right++;

        }

        return maxLen;

    }


}
