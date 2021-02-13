

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution{

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};


        List<Integer> list = findDisappearedNumbers(nums);

        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        if(nums == null){
            return null;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i])-1] > 0){
                nums[Math.abs(nums[i])-1] *= -1;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0 ){
                list.add(i+1);
            }
        }


        return list;

    }


}
