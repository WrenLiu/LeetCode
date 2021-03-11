

public class Solution {

    public static void main(String[] args) {

        System.out.println(checkOnesSegment("10"));

    }

    private static boolean checkOnesSegment_leetcode(String s){

        return !s.contains("01");
    }


    public static boolean checkOnesSegment(String s) {

        if(s == null || s.length() == 0){
            return false;
        }



        int rightIndex = s.lastIndexOf("1");

        for (int i = 0; i < rightIndex; i++) {

            if(s.charAt(i) == '0'){
                return false;
            }
        }

        return true;
    }



}
