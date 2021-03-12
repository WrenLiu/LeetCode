

public class Solution {


    public static void main(String[] args) {

    }

    static class MyHashSet {

        boolean[] map;

        /** Initialize your data structure here. */
        public MyHashSet() {
            map = new boolean[1000000];
        }

        public void add(int key) {

            map[key] = true;

        }

        public void remove(int key) {

            map[key] = false;

        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {

            return  map[key];

        }
    }

}
