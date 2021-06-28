

public class Solution {


    public static void main(String[] args) {

        String s = "axxxxyyyyb", part = "xy";

        System.out.println(removeOccurrences(s , part));


    }

    public static String removeOccurrences(String s, String part) {

        if(s == null || part == null){
            return s;
        }

        while(s.indexOf(part) >= 0 ){
            s = s.substring(0 , s.indexOf(part)) + s.substring(s.indexOf(part) + part.length() , s.length());
            System.out.println(s);
        }

        return s;

    }
}
