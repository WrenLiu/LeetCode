
import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {


        String s = "aababcabc";

        System.out.println(countGoodSubstrings(s));

    }

    public static int countGoodSubstrings(String s) {

        if(s == null || s.length() < 3){
            return 0;
        }


        int leftIndex = 0, rightIdnex = leftIndex + 3;

        int count = 0;

        while(rightIdnex <= s.length()){

            if(isOk(s.substring(leftIndex , rightIdnex))){
                System.out.println(s.substring(leftIndex, rightIdnex));
                count ++;
            }

            leftIndex++;
            rightIdnex++;
        }
        return count;
    }

    private static boolean isOk(String s){

        return s.charAt(0) != s.charAt(1) && s.charAt(0) != s.charAt(2) && s.charAt(1) != s.charAt(2);

    }


}
