import java.util.*;

public class Solution {


    public static void main(String[] args) {

        String s = "abbaca";
        System.out.println(removeDuplicates_Leetcode(s));
    }


    public static String removeDuplicates_Leetcode(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();



        for (int i = 0; i < s.length(); i++) {

            if(!stack.isEmpty() && stack.peek() == s.charAt(i)){

                stack.pop();

            }else{
                stack.push(s.charAt(i));
            }

        }

        StringBuffer stringBuffer = new StringBuffer();

        for (Character character : stack) {
            stringBuffer.append(character);
        }

        return stringBuffer.toString();



    }
    public static String removeDuplicates(String s) {

        if(s==null || s.length() <= 1){
            return s;
        }

        int len = s.length();

        ArrayList<Character> arrayList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            arrayList.add(s.charAt(i));
        }

        StringBuffer stringBuffer = new StringBuffer();
        int left = 0,right = 1;

        while (left >= 0 && right < arrayList.size()) {

            if( arrayList.get(left) == arrayList.get(right) ){

                arrayList.remove(left);
                arrayList.remove(left);

                if(left == 0){
                    right = 1;
                    left = 0;
                    continue;
                }
                right = left;


            }else{
                right++;
            }

            left = right-1;

        }

        for (Character character : arrayList) {
            stringBuffer.append(character);
        }






        return stringBuffer.toString();



    }

}
