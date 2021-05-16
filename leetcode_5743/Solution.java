
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int memory1 = 8, memory2 = 11;
        System.out.println(Arrays.toString(memLeak(memory1,memory2)));

    }
    public static int[] memLeak(int memory1, int memory2) {

        int[] res = new int[3];

        int second = 0;
        for (second = 1; Math.max(memory1,memory2) >= second; second++) {
            if(memory1 >= memory2){
                memory1 -= second;
            }else{
                memory2 -= second;
            }

        }

        res[0] = second;
        res[1] = memory1;
        res[2] = memory2;


        return res;

    }

}
