import javax.sound.sampled.Line;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {


    private static HashSet<Integer> hashSet;
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);

        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> permute(int[] nums) {

        if(nums == null){
            return null;
        }

        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        hashSet = new HashSet<>();

        helper(nums,res,list);



        return res;

    }

    private static void helper(int[] nums,List<List<Integer>> res,List<Integer> list){

        if(list.size() == nums.length){
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if(!hashSet.contains(nums[i])){


                list.add(list.size(),nums[i]);
                hashSet.add(nums[i]);
                helper(nums,res,list);

                hashSet.remove(nums[i]);
                list.remove(list.size()-1);

            }



        }



    }


}
