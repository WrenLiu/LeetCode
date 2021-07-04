

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {


    public static void main(String[] args) {


        int[] nums = {1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(nums)));

    }


    public int[] findErrorNums_leetcode(int[] nums) {
        int n = nums.length;
        int[] cnts = new int[n + 1];
        for (int x : nums) cnts[x]++;
        int[] ans = new int[2];
        for (int i = 1; i <= n; i++) {
            if (cnts[i] == 0) ans[1] = i;
            if (cnts[i] == 2) ans[0] = i;
        }
        return ans;
    }




    public static int[] findErrorNums(int[] nums) {

        if(nums == null){
            return null;
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        int[] res = new int[2];

        for (int num : nums) {
            if(treeSet.contains(num)){
                res[0] = num;
            }
            treeSet.add(num);
        }

        int index = 1;



        for (Integer integer : treeSet) {
            if(integer != index){

                res[1] = index;
                break;
            }

            index++;
        }


        if(res[1] == 0){
            res[1] = nums.length;
        }

        return res;




    }


}
