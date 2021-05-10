
import java.util.Arrays;

public class Solution{


    public static void main(String[] args) {

        int[] encoded = {3,1};

        System.out.println(Arrays.toString(decode(encoded)));

    }

    public static int[] decode(int[] encoded) {

        if(encoded == null){
            return null;
        }

        int[] res = new int[encoded.length+1];


        int total = 0;
        for (int i = 1; i < encoded.length + 2; i++) {
            total ^= i;
        }

        int odd = 0;
        for (int i = 1; i < encoded.length + 1; i += 2) {
            odd ^= encoded[i];
        }

        res[0] = total ^ odd;

        for (int i = 1; i < res.length; i++) {
            res[i] = res[i-1] ^ encoded[i-1];
        }





        return res;


    }


}
