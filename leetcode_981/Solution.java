

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {
        TimeMap kv = new TimeMap();

//["TimeMap","set","set","get","set","get","get"]
//[[],["a","bar",1],["x","b",3],["b",3],["foo","bar2",4],["foo",4],["foo",5]]


        kv.set("a","bar",1);
        kv.set("x","b",3);

        System.out.println(kv.get("b",5));
        System.out.println(kv.get("love",10));
        System.out.println(kv.get("love",15));
        System.out.println(kv.get("love" ,20));
        System.out.println(kv.get("love" ,25));


    }

    static class TimeMap {

        HashMap<String , TreeMap<Integer , String>> map;

        public TimeMap() {

            map = new HashMap<>();

        }

        public void set(String key, String value, int timestamp) {

            if(map.containsKey(key)){

                TreeMap<Integer , String> treeMap = map.get(key);
                treeMap.put(timestamp , value);

            }else{

                TreeMap<Integer , String> willBeAdd = new TreeMap<>();
                willBeAdd.put(timestamp , value);
                map.put(key , willBeAdd);
            }

        }

        public String get(String key, int timestamp) {

            if(!map.containsKey(key)){
                return "";
            }
            TreeMap<Integer , String> treeMap = map.get(key);

            if(treeMap.firstKey() > timestamp){
                return "";
            }
            return treeMap.get(treeMap.floorKey(timestamp));
        }
    }


}
