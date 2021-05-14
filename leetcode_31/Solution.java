
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {5,1,1};

        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }


    public static void nextPermutation(int[] nums) {

        if(nums == null || nums.length == 1){
            return;
        }

//        从后向前查找第一个相邻升序的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
//        在 [j,end) 从后向前查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
//        将 A[i] 与 A[k] 交换
//        可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
//        如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4

        int leftIndex = nums.length-2 , rightIndex = nums.length-1;

        while(leftIndex >= 0 && nums[leftIndex] >= nums[rightIndex]){
            leftIndex--;
            rightIndex--;
        }

        if(leftIndex == -1 ){

            Arrays.sort(nums);
            return;
        }

        int indexK = nums.length - 1;
        while(indexK > rightIndex && nums[indexK] <= nums[leftIndex]){
            indexK--;
        }

        int tmp = nums[indexK] ;
        nums[indexK] = nums[leftIndex];
        nums[leftIndex] = tmp;

        Arrays.sort(nums,rightIndex , nums.length);






    }

}
