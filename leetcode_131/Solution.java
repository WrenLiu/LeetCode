

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        String s = "cbbbcc";

        List<List<String>> list = partition(s);

        for (List<String> strings : list) {
            for (String string : strings) {
                System.out.println(string);
            }

            System.out.println("-----");
        }

    }
    public static List<List<String>> partition(String s) {

        if(s == null) {
            return null;
        }

        List<List<String>> result  = new LinkedList<>();
        List<String> list = new LinkedList<>();

        backTrace(s,result,list);

        return result;


    }

    private static void backTrace(String s,List<List<String>> result,List<String> list){

        if(s.length() == 0){

            result.add(new LinkedList<>(list));

            return;
        }

        for (int i = 1; i <= s.length(); i++) {

            String pre = s.substring(0,i);
            if(isPalindrome(pre)){

                list.add(list.size(),pre);
                backTrace(s.substring(i,s.length()),result,list);
                list.remove(list.size()-1);
            }

        }

    }

    private static boolean isPalindrome(String s){

        if(s.length() == 0){
            return true;
        }

        int left = 0;
        int right = s.length()-1;

        while (left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;

    }

}
