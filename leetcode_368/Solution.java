
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {1};



        List<Integer> list = largestDivisibleSubset(nums);

        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        System.out.println();


    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {



        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();
        int[] dpMax = new int[nums.length];
        int[] dpIndex = new int[nums.length];


        dpIndex[0] = 0;
        dpMax[0] = 1;

        for (int i = 1; i < nums.length; i++) {

            // max = 1 意味着从自身转移过来,
            int max= 1 ;
            for (int j = 0; j < i; j++) {
                if(nums[i] %nums[j] == 0){

                    if( dpMax[j]+1 > max ){
                        dpIndex[i] = j;
                        max = dpMax[j] + 1;
                    }

                }
            }

            dpMax[i] = max;

        }


        int maxIndex = 0, maxLen = dpMax[0];
        for (int i = 0; i < dpMax.length; i++) {

            if(maxLen < dpMax[i]){
                maxLen = dpMax[i];
                maxIndex = i;
            }
        }

        res.add(nums[maxIndex]);
        maxIndex = dpIndex[maxIndex];
        maxLen--;
        while(maxIndex >= 0 && maxLen > 0){

            res.add(nums[maxIndex]);
            maxLen--;
            maxIndex = dpIndex[maxIndex];

        }

        return res;


    }



}
