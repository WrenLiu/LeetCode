
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {


        String[] words = {"ab","a"};

        System.out.println(makeEqual(words));



    }
    public static boolean makeEqual(String[] words) {

        if(words == null){
            return false;
        }

        HashMap<Character,Integer> hashMap = new HashMap<>();
        int len = words.length;

        for (int i = 0; i < len; i++) {

            char[] chs = words[i].toCharArray();
            for (char ch : chs) {
                hashMap.put(ch, hashMap.getOrDefault(ch, 0)+1);
            }
        }

        for (Character character : hashMap.keySet()) {
            if(hashMap.get(character) % len != 0){
                return false;
            }

        }
        return true;



    }

}
