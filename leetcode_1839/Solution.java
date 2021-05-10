import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution{



    public static void main(String[] args) {

        String str = "aaaaeiiiiouuu";
        ArrayList<Character> chs = new ArrayList<>();
        chs.add('a');
        chs.add('e');
        chs.add('i');
        chs.add('o');
        chs.add('u');

        System.out.println(isBeautiful(0,str.length(),str,chs));

        System.out.println(longestBeautifulSubstring_mine("a"));
        System.out.println("-------------------------------");
        System.out.println(longestBeautifulSubstring_DoublePointer("a"));




        System.out.println();
    }



    // 速度提升很多
    public int longestBeautifulSubstring_Leetcode(String word) {
        int left = 0, right = 1, n = word.length(), res = 0;
        char[] nums = word.toCharArray();
        int[] map = new int[26];
        map[nums[0] - 'a']++;
        while (right < n) {
            //  判断 a e i o u 的顺序
            if (nums[right] - nums[right - 1] < 0) {

                // 标明 a e i o u 的数量
                if (map[0] > 0 && map[4] > 0 && map[8] > 0 && map[14] > 0 && map[20] > 0) {
                    res = Math.max(res, right - left);
                }
                Arrays.fill(map, 0);
                left = right;
            }
            map[nums[right] - 'a']++;
            right++;
        }
        // 字符串尾部特殊情况处理
        if (right == n && map[0] > 0 && map[4] > 0 && map[8] > 0 && map[14] > 0 && map[20] > 0)
            res = Math.max(res, right - left);
        return res;
    }


    public static int longestBeautifulSubstring_DoublePointer(String word){

        if(word == null){
            return 0;
        }
        int len = word.length();

        ArrayList<Character> chs = new ArrayList<>();
        chs.add('a');
        chs.add('e');
        chs.add('i');
        chs.add('o');
        chs.add('u');

        int leftIndex = 0 , rightIndex = 0;
        int maxLen = 0;



        while(rightIndex < len && leftIndex < len){


            while(leftIndex < len && word.charAt(leftIndex) != 'a'){
                leftIndex++;
            }

            rightIndex = leftIndex;

            while(rightIndex < len && word.charAt(rightIndex) != 'u'){
                rightIndex++;
            }

            while (rightIndex < len && word.charAt(rightIndex) == 'u'){
                rightIndex++;
            }


            System.out.println(leftIndex+" "+rightIndex);
            if(leftIndex+4 < rightIndex && isBeautiful(leftIndex , rightIndex,word,chs)){

                maxLen = Math.max(maxLen , rightIndex - leftIndex );

            }

            while(leftIndex < len && word.charAt(leftIndex) == 'a'){
                leftIndex++;
            }




        }

        return maxLen;





    }


    // 左闭右开
    private static boolean isBeautiful(int startIndex , int endIndex,String word , ArrayList<Character> chs){


        int curIndex = startIndex;
        if(word.charAt(curIndex) != 'a'){
            return false;
        }

        curIndex++;
        int preIndex = startIndex ;
        while(curIndex < endIndex ){
            if(chs.indexOf(word.charAt(curIndex)) == chs.indexOf(word.charAt(preIndex)) || chs.indexOf(word.charAt(curIndex)) == chs.indexOf(word.charAt(preIndex)) + 1 ){
                curIndex++;
                preIndex++;
                continue;
            }

            return false;

        }

        return word.charAt(curIndex-1) == 'u';
    }


    public static int longestBeautifulSubstring_mine(String word) {

        if(word == null){
            return 0;
        }

        ArrayList<Character> chs = new ArrayList<>();
        chs.add('a');
        chs.add('e');
        chs.add('i');
        chs.add('o');
        chs.add('u');

        int len = word.length();
        int[] dp = new int[len];

        dp[0] = 0;
        int lastUIndex = -1;
        char curCh = word.charAt(0);

        ArrayList<Integer> AIndex = new ArrayList<>();


        if(curCh == 'a'){
            AIndex.add(0);
        }


        for (int i = 1; i < len; i++) {
            curCh = word.charAt(i);
            int maxLen = 0;
            if(curCh == 'u' ){


                int arrIndex = 0;
                while(arrIndex < AIndex.size()) {

                    int tmpIndex = AIndex.get(arrIndex);

                    if(isBeautiful_mine(tmpIndex , i, word, chs)){

                        maxLen = Math.max(maxLen, i - tmpIndex +1 );
                        arrIndex++;
                    }else{
                        AIndex.remove(arrIndex);
                    }
                }


                if(lastUIndex != -1){

                    dp[i] = Math.max(dp[lastUIndex] , maxLen);
                    lastUIndex = i;
                }else {
                    lastUIndex = i;
                    dp[lastUIndex] = maxLen;
                }
            }

            if(curCh == 'a'){
                AIndex.add(i);
            }





        }


        System.out.println(Arrays.toString(dp));

        return lastUIndex == -1 ? 0 : dp[lastUIndex] ;

    }

    private static boolean isBeautiful_mine(int startIndex , int endIndex,String word , ArrayList<Character> chs){


        int curIndex = startIndex+1;
        char lastCh = word.charAt(curIndex -1);
        while(curIndex < endIndex+1){

            char curCh = word.charAt(curIndex);
            if(chs.contains(curCh) && (chs.indexOf(curCh) == chs.indexOf(lastCh)  || chs.indexOf(curCh) == chs.indexOf(lastCh)+1 )){
                lastCh = curCh;
                curIndex++;
            }else{
                return false;
            }
        }

        return true;



    }
}
