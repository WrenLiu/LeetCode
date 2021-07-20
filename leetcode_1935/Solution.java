import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {
        String text = "hello world", brokenLetters = "ad";
        System.out.println(canBeTypedWords(text , brokenLetters));

    }

    public static int canBeTypedWords(String text, String brokenLetters) {

        String[] strs = text.split(" ");
        HashSet<Character> hashSet = new HashSet<>();

        for (int i = 0; i < brokenLetters.length(); i++) {
            char ch = brokenLetters.charAt(i);
            hashSet.add(ch);
        }

        int res = 0;

        for (int i = 0; i < strs.length; i++) {

            boolean isOk = true;
            for (int j = 0; j < strs[i].length(); j++) {
                if(hashSet.contains(strs[i].charAt(j))){
                    isOk = false;
                    break;
                }
            }

            if(isOk){
                res++;
            }


        }


        return res;

    }
}
