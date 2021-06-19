
import java.util.*;

public class Solution {

    private static int res ;

    private static int ans ;
    static HashMap<Integer,Integer> hashMap = new HashMap<>();

    private static int get(int cur){

        if(hashMap.containsKey(cur)){
            return hashMap.get(cur);
        }

        int ans = 0;
        for (int i = cur; i > 0; i -= lowBit(i)) {
            ans++;
        }

        hashMap.put(cur, ans );
        return ans;

    }

    private static int lowBit(int x){
        return x & -x;
    }

    private static void dfs02(int u , int cur ,int total , int n , int[] alpha){

        if(get(cur | total) <=  ans) return;
        if(u == n){
            ans = Math.max(ans ,get(cur));
            return ;
        }

        // 在原有基础上，选择该数字（如果可以）
        if ((alpha[u] & cur) == 0) {
            dfs02(u + 1, alpha[u] | cur, total - (total & alpha[u]) , n , alpha);
        }
        // 不选择该数字
        dfs02(u + 1, cur, total , n , alpha);




    }

    public static int maxLength(List<String> list){
        HashSet<Integer> hashSet = new HashSet<>();

        // 预处理,计算总共有多少种字母
        for (String s : list) {
            int val = 0;
            for (char c : s.toCharArray()) {
                int t = (int)(c - 'a');
                if (((val >> t) & 1) != 0) {
                    val = -1;
                    break;
                }
                val |= (1 << t);
            }
            if (val != -1) hashSet.add(val);
        }

        int n = hashSet.size();
        if(n == 0) return 0;

        int [] alpha = new int[n];
        int idx = 0 ;
        int total = 0;
        for (Integer integer : hashSet) {
            alpha[idx++] = integer ;
            total |= integer;
        }

        ans = 0;
        dfs02(0 , 0 ,total , n, alpha);
        return ans;




    }

    /***********************************************************/
    private static boolean isOk(int[]  alphaCount){


        for (int i = 0; i < 26; i++) {
            if(alphaCount[i] > 1){
                return false;
            }
        }
        return true;
    }


    private static void backTrace(List<String> list , int index , int curLen , int[] alphaCount){

        if(index > list.size()){
            return;
        }

        if(isOk(alphaCount)){
            res = Math.max(res , curLen);

        }

        for (int i = index; i < list.size(); i++) {


            String tmp = list.get(i);
            int addLen = tmp.length();

            for (int j = 0; j < addLen; j++) {
                alphaCount[tmp.charAt(j) - 'a']++;
            }


            backTrace(list , i + 1, curLen + addLen , alphaCount);

            for (int j = 0; j < addLen; j++) {
                alphaCount[tmp.charAt(j) - 'a']--;
            }
        }




    }

    public static int maxLength_mine(List<String> arr) {

        if(arr == null || arr.size() == 0){
            return 0;
        }else if(arr.size() == 1){
            return arr.get(0).length();
        }

        res = 0;

        int[] alphaCount = new int[26];
        backTrace(arr , 0 , 0, alphaCount);


        return res;






    }


    public static void main(String[] args) {

        List<String> list = new LinkedList<>();

        String[] strs = {"a", "abc", "d", "de", "def"};

        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i]);
        }


        System.out.println(maxLength(list));

    }



}
