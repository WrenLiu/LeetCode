

import java.util.*;

public class Solution {

    private static List<List<Integer>> result;

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        List<List<Integer>> listRes = subsets(nums);
        
    }

    public static List<List<Integer>> subsets(int[] nums) {

        if(nums == null){
            return null;
        }

        result = new ArrayList<>();
        Set<Integer> set = new LinkedHashSet<>();
        dfs(set,nums,0);


        return result;
    }

    private static void dfs(Set<Integer> set, int[] nums,int index){


        List<Integer> listTmp = new ArrayList<>() ;
        listTmp.addAll(set);
        result.add(listTmp);


        for (int i = index; i < nums.length; i++) {
            set.add(nums[i]);
            dfs(set, nums, i+1);
            set.remove(nums[i]);

        }

    }

}
