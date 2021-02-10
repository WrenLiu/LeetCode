
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        String s1 = "zo";
        String s2 = "eidbaoooxz";
        System.out.println(checkInclusion(s1,s2));

    }

    public static boolean checkInclusion(String s1, String s2) {

        if(s1 == null || s2 == null || s1.length() > s2.length() ){
            return false;
        }

        int n = s1.length();

        HashMap<Character,Integer> hashMap01 = new HashMap<>(26);
        HashMap<Character,Integer> hashMap02 = new HashMap<>(26);
        for (int i = 0; i < 26; i++) {
            hashMap01.put((char)('a'+i),0);
            hashMap02.put((char)('a'+i),0);
        }

        int left = 0,right = s1.length();

        for (int i = 0; i < s1.length(); i++) {
            hashMap01.put(s1.charAt(i),hashMap01.get(s1.charAt(i))+1);
            hashMap02.put(s2.charAt(i),hashMap02.get(s2.charAt(i))+1);
        }


        if(hashMap01.equals(hashMap02)){
            return true;
        }

        while(right < s2.length()){
            hashMap02.put(s2.charAt(left),hashMap02.get(s2.charAt(left))-1);
            hashMap02.put(s2.charAt(right),hashMap02.get(s2.charAt(right))+1);
            for (Character character : hashMap02.keySet()) {
                System.out.print(character+" "+hashMap02.get(character)+"  ");
            }
            System.out.println();
            if(hashMap01.equals(hashMap02)){
                return true;
            }
            ++left;
            ++right;

        }







        return false;

    }

}
