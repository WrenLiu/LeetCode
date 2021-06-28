
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {


        String word = "aabb";
        System.out.println(wonderfulSubstrings(word));

    }
    public static long wonderfulSubstrings(String word) {


        long res = 0;
        int mask = 0 ;
        long[] freq = new long[1<<10];

        freq[0] = 1;




        for (char ch : word.toCharArray()) {

            int index = ch - 'a';
            // mask 是统计奇偶数的
            mask ^= (1 << index);
            res += freq[mask];


            for (int i = 0; i < 10; i++) {
                res += freq[mask ^ (1 << i)];

            }
            freq[mask] ++;


        }



        return res;

    }


}
