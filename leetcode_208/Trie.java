
import java.util.*;


class Trie {
    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node(boolean isWord ){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private int size;
    private Node root;

    public Trie(){
        root = new Node();
        size = 0;
    }

    public int getSize(){
        return  size;
    }

    /**
     *  增操作 : 向Trie中添加字符串
     *  可尝试利用递归实现
     */
    public void insert(String word){

        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);

        }
        // 判断是否存在这个char
        if(cur.isWord != true) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查操作:
     */
    public boolean search(String word){

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.next.containsKey(c) == true){
                cur = cur.next.get(c);
            }
            else {
                return false;
            }
        }

        return cur.isWord;
    }

    // 查询是否在Trie中有单词以prefix为前缀
    public boolean startsWith(String prefix){

        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.next.containsKey(c)){
                cur = cur.next.get(c);
            }
            else{
                return false;
            }
        }

        return true;
    }






}
