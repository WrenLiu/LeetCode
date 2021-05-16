
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {14,70,53,83,49,91,36,80,92,51,66,70};
        System.out.println(findMaximumXOR(nums));
        System.out.println(findMaximumXOR_Trie(nums));

    }

    public static int findMaximumXOR(int[] nums) {

        if(nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }

        if(nums.length == 2){
            return nums[0] ^ nums[1];
        }

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {

                res = Math.max(res , nums[i] ^ nums[j]);


            }
        }

        return res;



    }

    // static 成员整个类独一份，只有在类首次加载时才会创建，因此只会被 new 一次
    static int N = (int)1e6;
    static int[][] trie = new int[N][2];
    static int idx = 0;
    // 每跑一个数据，会被实例化一次，每次实例化的时候被调用，做清理工作
    public Solution421() {
        for (int i = 0; i <= idx; i++) {
            Arrays.fill(trie[i], 0);
        }
        idx = 0;
    }
    public static void add(int x) {
        int p = 0;
        for (int i = 31; i >= 0; i--) {
            int u = (x >> i) & 1;
            if (trie[p][u] == 0) trie[p][u] = ++idx;
            p = trie[p][u];
        }
    }
    public static int getVal(int x) {
        int ans = 0;
        int p = 0;
        for (int i = 31; i >= 0; i--) {
            int a = (x >> i) & 1, b = 1 - a;
            if (trie[p][b] != 0) {
                ans |= (b << i);
                p = trie[p][b];
            } else {
                ans |= (a << i);
                p = trie[p][a];
            }
        }
        return ans;
    }
    public static int findMaximumXOR_Trie(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            add(i);
            int j = getVal(i);
            ans = Math.max(ans, i ^ j);
        }
        return ans;
    }

}
