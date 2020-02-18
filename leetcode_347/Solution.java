package tmp;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Solution {

    private class Freq implements Comparable<Freq> {
        public int e, freq;

        public Freq(int e,int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq > another.freq) {
                return 1;
            }
            else if (this.freq == another.freq) {
                return 0;
            }
            else {
                return -1;
            }
        }

        public List<Integer> topKFrequent(int[] nums, int k) {

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    // map中改变某个key的值是通过put()函数
                    map.put(nums[i], map.get(nums[i]) + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }

            // 优先队列恒存放着频率前k高的元素
            PriorityQueue<Freq> newFreq = new PriorityQueue<>();

            // 使用keySet()方法获取所有的key值
            for (int key:map.keySet()) {
                if(newFreq.getSize() < k){
                    newFreq.enqueue(new Freq(key , map.get(key)));
                }
                else if(map.get(key)>newFreq.getFront().freq){
                    newFreq.dequeue();
                    newFreq.enqueue(new Freq(key ,map.get(key)));
                }
            }

            LinkedList<Integer> list = new LinkedList<>();
            while(!newFreq.isEmpty()){
                list.add(newFreq.dequeue().e);
            }

            return list;
        }
    }
}