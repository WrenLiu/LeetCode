

import java.util.*;

class WordDictionary {

    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord ){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length() ; i++) {
            char c = word.charAt(i);
            if(!cur.next.containsKey(c)){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        if(cur.isWord != true) {
            cur.isWord = true;
        }

        //cur.isWord = true;

    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        // index 是随着word依次前进的,相当于前面的i
        return match(root,word,0);
    }

    private boolean match(Node node ,String word ,int index) {
        // index 索引已经是要考虑的字符串的总长度
        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);

        if (c != '.') {
            if (!node.next.containsKey(c)) {
                return false;
            }
            else {
                return match(node.next.get(c), word, index + 1);
            }
        }
        else {
            // keySet 取出来所有的键组成一个集合
            // 继续对nextChar部分进行匹配,如果匹配成功就返回true,失败就返回false
            for (char nextChar : node.next.keySet()) {
                if (match(node.next.get(nextChar), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }


}
