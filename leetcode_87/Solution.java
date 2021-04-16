
import java.util.HashMap;

public class Solution {

    public static String s1,s2;
    public static int n;
    private static int[][][] cache;
    public static int N = -1, Y = 1, EMPTY = 0;


    public static void main(String[] args) {

        String s1 = "great";
        String s2 = "rgeat";

        System.out.println(isScramble_Mine(s1,s2));

    }

    public static boolean isScramble(String _s1, String _s2) {

        if(_s1 == null || _s2 == null || _s1.length() != _s2.length() || !check(_s1,_s2)){
            return false;
        }

        if(_s1.equals(_s2)){
            return true;
        }

        int len = _s1.length();

        s1 = _s1; s2 = _s2;

        // cache 的默认值是 EMPTY
        cache = new int[len][len][len + 1];
        return dfs(0, 0, len);
    }




    public static boolean dfs(int i, int j, int len) {

        if (cache[i][j][len] != EMPTY) {
            return cache[i][j][len] == Y;
        }

        String a = s1.substring(i, i + len), b = s2.substring(j, j + len);

        if (a.equals(b)) {
            cache[i][j][len] = Y;
            return true;
        }
        if (!check(a, b)) {
            cache[i][j][len] = N;
            return false;
        }

        for (int k = 1; k < len; k++) {

            // 对应了「s1 的 [0,i) & [i,n)」匹配「s2 的 [0,i) & [i,n)」
            if (dfs(i, j, k) && dfs(i + k, j + k, len - k)) {
                cache[i][j][len] = Y;
                return true;
            }


            // 对应了「s1 的 [0,i) & [i,n)」匹配「s2 的 [n-i,n) & [0,n-i)」
            if (dfs(i, j + len - k, k) && dfs(i + k, j, len - k)) {
                cache[i][j][len] = Y;
                return true;
            }
        }

        cache[i][j][len] = N;

        return false;
    }

    public static boolean isScramble_Mine(String s1, String s2) {

        if(s1 == null || s2 == null ){
            return false;
        }

        if(s1.equals(s2)){
            return true;
        }

        if(!check(s1,s2)){
            return false;
        }

        int len = s1.length();

        for (int i = 1; i < len; i++) {
            String a = s1.substring(0,i), b = s1.substring(i,s1.length());

            String c = s2.substring(0,i), d = s2.substring(i,s2.length());

            if(isScramble(a,c) && isScramble(b,d)) return true;

            String e = s2.substring(0,len-i), f = s2.substring(len-i,s2.length());

            if(isScramble(a,f) && isScramble(b,e)) return true;

        }

        return false;


    }

    public static boolean check(String s1,String s2){

        if (s1.length() != s2.length()) return false;

        int[] alpha = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            alpha[s1.charAt(i) - 'a']++;
            alpha[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if(alpha[i] != 0){
                return false;
            }
        }

        return true;

    }


}
