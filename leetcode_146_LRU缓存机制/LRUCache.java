import java.util.*;

class LRUCache {

    private int capacity;
    private LinkedList list = new LinkedList();
    private HashMap<Integer,Integer> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(list.contains(key)){
            list.remove((Integer)key);
            list.add(key);

            return map.get(key);
        }
        {
            return  -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            list.remove((Integer)key);
        }
        else{
            if(list.size() == capacity){
                map.remove(list.removeFirst());
            }
        }

        map.put(key,value);
        list.add(key);
    }


}