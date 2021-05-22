
public class Solution {
    public static void main(String[] args) {

        int[] nums = {1, 1, 2};
        System.out.println(xorGame(nums));

    }

    public static boolean xorGame(int[] nums) {
        if(nums == null){
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }

        return sum == 0 || nums.length % 2 == 0;

    }


}
