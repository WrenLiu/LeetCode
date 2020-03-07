package leetcode_387;
public class Solution {
    public static int firstUniqChar(final String s) {
        final int[] freq = new int[26];


        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        firstUniqChar("loveleetcode");
        
    }
}