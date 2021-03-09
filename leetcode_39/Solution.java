

import javax.jnlp.IntegrationService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        int[] nums = {2,3,6,7};

        List<List<Integer>> res = combinationSum(nums,7);

        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer+" ");
            }

            System.out.println();
        }

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(candidates == null || target < 0){
            return null;
        }

        Arrays.sort(candidates);

        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();




        helper(candidates,target,0,res,list);
        return res;


    }

    private static void helper(int[] nums,int target ,int start,List<List<Integer>> res,List<Integer> list){

        if(target < 0){
            return;
        }else if(target == 0){

            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            if(target - nums[i] < 0){
                break;
            }

            list.add(list.size(),nums[i]);
            target -= nums[i];
            helper(nums,target,i,res,list);
            list.remove(list.size()-1);
            target += nums[i];



            }


    }






}
