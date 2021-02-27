
import java.util.HashMap;

public class Solution395 {


    public static void main(String[] args) {

        String s = "ababbc";
        System.out.println(longestSubstring(s,2));


    }

    public static int longestSubstring(String s, int k) {

        if(s == null || k <= 0){
            return 0;
        }

        return helper(s,k);

    }

    private static int helper(String s ,int k){

        if(s.length() < k){
            return 0;
        }

        int index = -1;

        int[] alphas = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphas[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(alphas[i] != 0 && alphas[i] < k ){
                index = s.indexOf((char)(i + 'a'));
                break;
            }
        }
        if(index == -1){
            System.out.println(s);
            return s.length();
        }else{
            return Math.max(helper(s.substring(0,index),k),helper(s.substring(index+1,s.length()),k));
        }





    }




}
