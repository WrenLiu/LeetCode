

public class Solution {

    public static void main(String[] args) {

        MyHashMap_Leetcode hashMap = new MyHashMap_Leetcode();

        hashMap.put(1,1);
        hashMap.put(2,2);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));
        hashMap.put(2,1);
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));



    }

    static class Node{

        int key , value;
        Node next ;

        Node(int key,int value){

            this.key = key;
            this.value = value;
            this.next = null;
        }

    }

    // 可变长数组实现
    static class MyHashMap_Leetcode {

        // 10009 是 10000 之后的第一个质数
        Node[] nodes;


        /** Initialize your data structure here. */
        public MyHashMap_Leetcode() {

            // 即将全部数据分散到 10009 这个范围上了
            nodes = new Node[10009];

        }

        /** value will always be non-negative. */
        public void put(int key, int value) {

            int index = getIndex(key);

            Node curNode = nodes[index];

            if(curNode != null){
                Node prev = null;

                while(curNode != null){

                    if(curNode.key == key){
                        curNode.value = value;
                        return ;
                    }
                    prev = curNode;
                    curNode = curNode.next;
                }

                curNode = prev;
            }

            Node node = new Node(key,value);
            if(curNode != null){
                curNode.next = node;
            }else {
                nodes[index] = node;
            }


        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {

            int index = getIndex(key);

            Node tmpNode = nodes[index];


            if(tmpNode != null){
                while(tmpNode != null) {
                    if (tmpNode.key == key) {
                        return tmpNode.value;
                    }

                    tmpNode = tmpNode.next;
                }

            }

            return -1;

        }

        private static int getIndex(int num){

            // 为了使hashCode的高位随机性和低位随机性体现在16位上
            int hash = Integer.hashCode(num);
            hash ^= (hash >> 16);
            return hash % 10009;

        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {

            int index = getIndex(key);


            Node curNode = nodes[index];


            if(curNode != null){

                Node preNode = null;
                while(curNode != null){

                    if(curNode.key == key){

                        if(preNode == null){
                            nodes[index] = curNode.next;
                        }else{
                            preNode.next = curNode.next;
                        }
                        return;
                    }
                    preNode = curNode;
                    curNode = curNode.next;

                }



            }

        }
    }


    // 数组实现
    static class MyHashMap {

        private static int[] nums ;
        private static boolean[] hasNum;


        /** Initialize your data structure here. */
        public MyHashMap() {

            nums = new int[1000000];
            hasNum = new boolean[1000000];

        }

        /** value will always be non-negative. */
        public void put(int key, int value) {

            if(hasNum[key] == true){
                nums[key] = value;
            }else {
                hasNum[key] = true;
                nums[key] = value;
            }

        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {

            if(hasNum[key] == true){
                return nums[key];
            }else {
                return -1;
            }

        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {

            if(hasNum[key] == true){
                hasNum[key] = false;
                nums[key] = 0;
            }

        }
    }


}
