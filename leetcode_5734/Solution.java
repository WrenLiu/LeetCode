
public class Solution {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(checkIfPangram(s));

    }

    public static boolean checkIfPangram(String sentence) {


        if(sentence == null){
            return false;
        }

        int[] alpha = new int[26];

        for (int i = 0; i < sentence.length();i++){


            char ch = sentence.charAt(i);

            alpha[ch-'a']++;


        }


        for (int i = 0; i < 26; i++) {

            if(alpha[i] == 0){
                return false;
            }
        }


        return true;


    }
}
