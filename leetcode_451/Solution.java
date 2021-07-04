
import java.util.*;


public class Solution {

    public static void main(String[] args) {

        System.out.println(frequencySort("Aabb"));

    }

    public static String frequencySort(String s) {

        if(s == null || s.length() <= 2){
            return s;
        }

        int len = s.length();

        char[] res = new char[len];

        Map<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < len; i++) {
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());

        Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>() {
            //升序排序
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int index = 0;
        for (Map.Entry<Character, Integer> e: list) {

            int tmpLen = e.getValue();
            char ch = e.getKey();


            for (int i = 0; i < tmpLen; i++) {
                res[index++] = ch;
            }

        }

        return String.valueOf(res);



    }

}
