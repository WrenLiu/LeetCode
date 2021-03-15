

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution{

    public static void main(String[] args) {

        String s1 = "aa" , s2 = "bb";

        System.out.println(areAlmostEqual(s1,s2));

    }

    public static boolean areAlmostEqual(String s1, String s2) {

        if(s1 == null || s2 == null){
            return false;
        }else if(s1.length() == 0 && s2.length() == 0){
            return true;
        }else if(s1.length() != s2.length()){
            return false;
        }

        int len = s1.length();
        char s1Char = '0',s2Char = '0';

        int count = 2;

        for (int i = 0; i < len; i++) {

            if(s1.charAt(i) != s2.charAt(i) ){
                if(count == 0){
                    return false;
                }
                count -- ;

                if(count == 1){
                    s1Char = s1.charAt(i);
                    s2Char = s2.charAt(i);
                }else if(count == 0){

                    if(s2Char != s1.charAt(i) || s1Char != s2.charAt(i)){

                        return false;
                    }

                }








            }


        }




        if(count == 1){
            return false;
        }

        return true;

    }


}
