import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        String[] words = { "aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};


        
        List<Integer> list = findNumOfValidWords_Op(words,puzzles);

        for (Integer integer : list) {
            System.out.println(integer);
        }

//        List<Integer> list = findNumOfValidWords(words,puzzles);

    }

    public static List<Integer> findNumOfValidWords_Op(String[] words, String[] puzzles) {
        if(words == null || puzzles == null ){
            return null;
        }

        List<Integer> list = new LinkedList<>();

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (String word : words) {

            int tmp = 0;
            // 因为不需要统计字符的数量，所以将一整个字符串全部存储在一个int里面
            for (int i = 0; i < word.length(); i++) {
                tmp |= (1<<word.charAt(i)-'a');
            }

            hashMap.put(tmp,hashMap.getOrDefault(tmp,0)+1);
        }

        for (int i = 0; i < puzzles.length; i++) {

            char[] puzzzle = puzzles[i].toCharArray();

            list.add(dfs(puzzzle,hashMap,1,1<<puzzzle[0]-'a'));

        }

        return list;
    }

    private static int dfs(char[] puzzle , HashMap<Integer,Integer> hashMap , int index, int key){

        if(index == puzzle.length){
            return hashMap.getOrDefault(key,0);
        }

        return dfs(puzzle,hashMap,index+1,key) + dfs(puzzle,hashMap,index+1,key | 1 << (puzzle[index] - 'a' ) );


    }

    // 超时
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        if(words == null || puzzles == null ){
            return null;
        }

        List<Integer> list = new LinkedList<>();
        HashSet<Character> hashSet = new HashSet<>();


        for (int i = 0; i < puzzles.length; i++) {
            char cFirst = puzzles[i].charAt(0);
            for (int j = 0; j < puzzles[i].length(); j++) {
                hashSet.add(puzzles[i].charAt(j));
            }
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if(words[j].indexOf(cFirst) == -1){
                    continue;
                }
                int k = 0;
                for ( ; k < words[j].length(); k++) {
                    if(!hashSet.contains(words[j].charAt(k))){
                        break;
                    }

                }

                if(k == words[j].length()){
                    count++;
                }
            }

            list.add(count);

            hashSet = new HashSet<>();


        }

        return list;


    }




}
