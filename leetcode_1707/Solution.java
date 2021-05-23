import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {0,1,2,3,4};
        int[][] queries =  {{3,1},{1,3},{5,6}};
        int[] res = maximizeXor_mine(nums,queries);

        System.out.println(Arrays.toString(res));

    }
    static int N = (int)1e5 * 32;
    static int[][] trie = new int[N][2];
    static int idx = 0;

    public Solution1707(){

        for (int i = 0; i <= idx; i++) {
            Arrays.fill(trie[i], 0);
        }
        idx = 0;

    }

    private static int Trie_getVal(int x){

        int res = 0;
        int p = 0;

        for (int i = 31; i >= 0 ; i--) {

            int a = (x>>i) & 1;
            int b = 1 -a ;
            if(trie[p][b] != 0 ){
                p = trie[p][b];
                res |= (b << i);
            }else{
                p = trie[p][a];
                res |= (a << i);
            }
        }

        return res ^ x;


    }

    private static void Trie_add(int num){

        int p = 0;
        for (int i = 31; i >= 0 ; i--) {

            int u = (num>>i) & 1;

            if(trie[p][u] == 0)
                trie[p][u] = ++idx;
            p = trie[p][u];
        }

    }

    public static int[] maximizeXor(int[] nums , int[][] queries){
        if(nums == null || queries == null){
            return null;
        }

        // 使用哈希表将原本的顺序保存下来
        HashMap<int[] ,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            hashMap.put(queries[i], i );
        }

        // 将nums 和 queries进行从小到大排序，这样可以避免Trie的频繁更换
        Arrays.sort(nums);
        Arrays.sort(queries , (a,b)->a[1]-b[1]);

        int[] res = new int[queries.length];
        int loc = 0;

        for (int[] query : queries) {

            int x = query[0],limit  = query[1];
            // 将小于等于limit的数存入 Trie
            while(loc < nums.length && nums[loc] <= limit) Trie_add(nums[loc++]);

            if(loc == 0){
                res[hashMap.get(query)] = -1;
            }else{
                res[hashMap.get(query)] = Trie_getVal(x);
            }

        }


        return res;






    }

    public static int[] maximizeXor_mine(int[] nums, int[][] queries) {

        if(nums == null || queries == null){
            return null;
        }

        int[] res = new int[queries.length];

        Arrays.sort(nums);

        int len = queries.length;
        for (int i = 0; i < len ; i++) {

            int biggest = queries[i][1];
            int num = queries[i][0];
            int resNum = -1;
            int numsIndex = 0;

            while(numsIndex < nums.length){

                if(nums[numsIndex] > biggest){
                    break;
                }

                resNum = Math.max(resNum , num ^ nums[numsIndex]);
                numsIndex++;
            }

            res[i] = resNum;


        }

        return res;


    }



}
