

public class Solution {

    public static void main(String[] args) {

        System.out.println(isPowerOfTwo(218));

    }

    public static boolean isPowerOfTwo(int n) {


        if(n<=0) return false;

        if((n&n-1)==0) return true;

        return false;





    }



}
