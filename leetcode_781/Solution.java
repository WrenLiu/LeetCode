

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        int[] ans = {1, 1, 2};
        System.out.println(numRabbits(ans));

    }

    public static int numRabbits(int[] answers) {
        if(answers == null || answers.length == 0){
            return 0;
        }


        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int res = 0;


        for (int answer : answers) {

            if(hashMap.containsKey(answer) && hashMap.get(answer) > 0){
                // 说明之间有兔子和这个兔子是相同颜色的，可以当做已经加过了
                hashMap.put(answer , hashMap.get(answer)-1);
            }else {

                // 加这种颜色的
                res += answer + 1;
                hashMap.put(answer,answer);
            }
        }

        return res;

    }


}
