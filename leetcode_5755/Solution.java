


import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {4,1,5,1,2,5,1,5,5,4};

        System.out.println(minPairSum(nums));


    }

    public static int minPairSum(int[] nums) {
        //最大数对和 的值 最小 。
        // 第 k 大与第 k 小组成的 n/2 个数对，同样可以使得最大数对和最小。



        if(nums == null || nums.length < 2 || nums.length % 2 != 0){
            return 0;
        }

        Arrays.sort(nums);


        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length/2; i++) {
            treeSet.add(nums[i] + nums[nums.length-1-i]);
        }


        return treeSet.last();

    }


}

