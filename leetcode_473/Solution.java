
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {


    private static boolean res;

    public static void main(String[] args) {

// 输入: [3,3,3,3,4]
//输出: false
        int[] nums = {8,3,16,17,5,1,3,19,14,15,7,14,8,17,16};

        System.out.println(makesquare(nums));

    }


    public static boolean makesquare(int[] matchsticks) {

        if(matchsticks == null || matchsticks.length < 4){
            return false;
        }
        int total = 0;

        for (int matchstick : matchsticks) {
            total += matchstick;
        }

        int[] sides = new int[4];

        res = false;
        int sideLen = total / 4;

        dfs(matchsticks ,  0 , sideLen ,  sides);

        return res;




    }

    private static void dfs(int[] nums ,  int index , int sideLen , int[] sides ){

        if(index == nums.length){
            if(sides[0] == sideLen && sides[1] == sideLen && sides[2] == sideLen && sides[3] == sideLen){
                res = true;
            }

            return ;
        }

        for (int i = 0; i < 4; i++) {

            if(sides[i] + nums[index] <= sideLen){
                sides[i] += nums[index];
                dfs(nums , index+1 , sideLen , sides );
                sides[i] -= nums[index];
            }

            // index的边长已经超过sideLen || 已经和最后结果边长相等 可以直接退出
            if (sides[i] == 0 || sides[i] + nums[index] == sideLen){
                break;
            }

        }



    }

}
