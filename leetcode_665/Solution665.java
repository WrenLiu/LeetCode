/**
 * 	4，2，3
 * 	-1，4，2，3
 * 	2，3，3，2，4
 * 我们通过分析上面三个例子可以发现，当我们发现后面的数字小于前面的数字产生冲突后，
 * [1]有时候需要修改前面较大的数字(比如前两个例子需要修改4)，
 * [2]有时候却要修改后面较小的那个数字(比如前第三个例子需要修改2)，
 * 那么有什么内在规律吗？是有的，判断修改那个数字其实跟再前面一个数的大小有关系，
 * 首先如果再前面的数不存在，比如例子1，4前面没有数字了，我们直接修改前面的数字为当前的数字2即可。
 * 而当再前面的数字存在，并且小于当前数时，比如例子2，-1小于2，我们还是需要修改前面的数字4为当前数字2；
 * 如果再前面的数大于当前数，比如例子3，3大于2，我们需要修改当前数2为前面的数3。
 */

public class Solution665 {

    public static void main(String[] args) {
        // 这个题不能只看每两个数字的下降次序
        int[] nums = {4,2,1};
        System.out.println(checkPossibility(nums));

    }


    public static boolean checkPossibility(int[] nums) {

        if(nums == null || nums.length == 0){
            return false;
        }
        int count = 0;

        for (int i = 1; i < nums.length; i++) {

            if(i == 1 && nums[i] < nums[i-1] ){
                count++;
                nums[i-1] = nums[i];
            }else if(i > 1 && nums[i-2] <= nums[i] && nums[i-1] > nums[i]){
                count++;
                nums[i-1] = nums[i];
            }else if(i > 1 && nums[i-2] > nums[i] && nums[i-1] > nums[i]){
                count++;
                nums[i] = nums[i-1];
            }


            if(count > 1){
                return false;
            }

            
        }
 


        return true;


    }

}
