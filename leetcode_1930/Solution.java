import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {

        String s = "bbcbaba";

        System.out.println(countPalindromicSubsequence_mine(s));


    }

    public static int countPalindromicSubsequence(String _s){

        if(_s == null || _s.length() < 3){
            return 0;
        }


        int len = _s.length();
        char[] s = _s.toCharArray();

        int res = 0;


        for (char ch = 'a'; ch <= 'z' ; ch++) {

            int leftIndex = 0 , rightIndex = len - 1;

            // 寻找ch第一次出现在的下标
            while(leftIndex < len && s[leftIndex] != ch){
                leftIndex++;
            }

            // 寻找ch最后一次出现的下标
            while(rightIndex >= 0 && s[rightIndex] != ch){
                --rightIndex;
            }


            if(rightIndex - leftIndex < 2){
                continue;
            }


            HashSet<Character> set = new HashSet<>();
            for (int i = leftIndex+1; i < rightIndex; i++) {
                set.add(s[i]);
            }


            res += set.size();



        }



        return res;






    }


    // 超时
    public static int countPalindromicSubsequence_mine(String s) {

        if(s == null || s.length() < 3){
            return 0;
        }

        HashMap<Character , ArrayList<Integer>> hashMap = new HashMap<>();
        HashMap<Character , HashSet<Character>> alphaCount = new HashMap<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(hashMap.containsKey(s.charAt(i))){
                hashMap.get(s.charAt(i)).add(i);
            }else{
                ArrayList<Integer> arrTmp = new ArrayList<>();
                arrTmp.add(i);
                hashMap.put(s.charAt(i) , arrTmp);
            }
        }

        int res = 0;

        for (Character ch : hashMap.keySet()) {

            ArrayList<Integer> arr = hashMap.get(ch);

            if(arr.size() == 1){
                continue;
            }

            HashSet<Character> setWillBeAdded = new HashSet<>();

            for (int i = 0; i < arr.size(); i++) {

                int left = arr.get(i);
                for (int j = i+1; j < arr.size(); j++) {

                    int right = arr.get(j);
                    if(right - left == 1){
                        continue;
                    }

                    for (int k = left+1; k < right; k++) {
                        setWillBeAdded.add(s.charAt(k));
                    }

                }
            }
            alphaCount.put(ch , setWillBeAdded);
            res += setWillBeAdded.size();


        }


        return res;
    }


}
