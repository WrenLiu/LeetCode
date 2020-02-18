
import java.util.*;


class Solution {

    private class Freq implements Comparable<Freq> {
        public int e;
        public int freq;

        public Freq(int e,int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return -1;
            }
            else if (this.freq == another.freq) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                    
                map.put(nums[i], map.get(nums[i]) + 1);
            } 
            else {
                    map.put(nums[i], 1);
            }
        }


        PriorityQueue<Freq> newFreq = new PriorityQueue<>();

           
        for (int key:map.keySet()) {
            if(newFreq.size() < k){
                newFreq.add(new Freq(key , map.get(key)));
            }
            else if(map.get(key)>newFreq.peek().freq){
                newFreq.remove();
                newFreq.add(new Freq(key ,map.get(key)));
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        while(!newFreq.isEmpty()){
            list.add(newFreq.remove().e);
        }

        return list;
    }
    
}