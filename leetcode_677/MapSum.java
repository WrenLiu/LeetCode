package tmp;
import java.util.*;

class MapSum {



    private class Node{
        // isWord可以用value得以观察
        public int value;

        public TreeMap<Character,Node> next;

        public Node(int value){
            this.value = value;
            next = new TreeMap<>();
        }

        public Node(){
            this(0);
        }
    }

    private Node root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();

    }

    public void insert(String word, int val) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.next.containsKey(c)){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }

        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(!cur.next.containsKey(c)){
                return 0;
            }
            cur = cur.next.get(c);
        }
        // 此时到达前缀的最后一个节点
        return sum(cur);

    }

    //sum 的遍历是到达cur节点通过递归直接到达Trie树的最低端向上走
    private int sum( Node node){


        int res = node.value;

        for ( char c : node.next.keySet()){
            res += sum(node.next.get(c));
        }

        System.out.print(res+" ");
        return res;

    }

    public static void main(String[] args){
        int sum =0;
        MapSum mapsum = new MapSum();

        mapsum.insert("appletree",7);
        mapsum.insert("apple",5);
        mapsum.insert("app",3);

        sum = mapsum.sum("ap");

        System.out.println("SUM: "+sum);


        System.out.println("Hello World.");
    }
}

