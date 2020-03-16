
public class Solution {
    public static int minSteps(String s, String t) {
        // 存放字母的量

        int[] sc = new int[26];
        int[] tc = new int[26];

        int len = s.length();
        // int len = s.size;

        for (int i = 0; i < len; i++) {
            sc[s.charAt(i) - 'a']++;
            tc[t.charAt(i) - 'a']++;
        }
        int num = len;
        for (int i = 0; i < 26; i++) {
            int minu = Math.min(sc[i], tc[i]);
            num -= minu;
        }

        return num;
    }


}