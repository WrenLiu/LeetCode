
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        String[] words =  {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        List<String> list = topKFrequent(words , 4);

        System.out.println("---------------------");
        for (String string : list) {
            System.out.println(string);
        }

    }

    public static List<String> topKFrequent(String[] words, int k) {

        if(words == null || k < 0){
            return null;
        }

        TreeMap<String, Integer> treeMap = new TreeMap<>();

        for (String word : words) {
            treeMap.put(word,treeMap.getOrDefault(word,0)+1);
        }
        //这里将map.entrySet()转换成list
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(treeMap.entrySet());
        //然后通过比较器来实现排序

        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                if(o1.getValue() != o2.getValue()){
                    return o2.getValue() - o1.getValue();
                }else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });


        List<String> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            res.add(list.get(i).getKey());
        }


        return res;




    }


}
