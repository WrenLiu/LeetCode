
import java.util.*;

public class Solution {


    public static void main(String[] args) {

        int[] nums = {1,2,2};
//        int[] nums = {4,1,0};
//        int[] nums = {0};

        List<List<Integer>> lists = subsetsWithDup_leetcode(nums);

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }

            System.out.println();
        }
    }

    public static List<List<Integer>> subsetsWithDup_leetcode(int[] nums) {

        if(nums == null ) {
            return null;
        }

        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        backtrace(0,nums,res,new ArrayList<Integer>());
        return res;


    }

    private static void backtrace(int index, int[] nums, List<List<Integer>> res , ArrayList<Integer> arrayList){

        res.add(new ArrayList<>(arrayList));

        for (int i = index; i < nums.length; i++) {

            //剪枝 去重
            if(i>index && nums[i] == nums[i-1]){
                continue;
            }

            arrayList.add(arrayList.size(), nums[i]);

            backtrace(i+1,nums,res,arrayList);

            arrayList.remove(arrayList.size()-1);


        }

    }


    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        if(nums == null ) {
            return null;
        }

        List<List<Integer>> res = new LinkedList<>();

        List<Integer> list = new ArrayList<>();


        helper(nums, res , list,  0 );

        return res;



    }


    private static void helper( int[] nums, List<List<Integer>> res ,List<Integer> list, int begin){
        List<Integer> tmp = new LinkedList<>(list);
        tmp.sort(((o1, o2) -> o2 - o1));
        if(!res.contains(tmp)){

            res.add(new LinkedList<>(tmp));
        }

        for (int i = begin; i < nums.length; i++) {

            list.add(list.size(),nums[i]);

            helper(nums,res,list, i+1);

            list.remove(list.size()-1);

        }




    }
}
