
public class Solution {


    public static void main(String[] args) {

        System.out.println(isPowerOfFour(16));

    }

    public static boolean isPowerOfFour(int n) {

        if (n < 1) return false;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    public static boolean isPowerOfFour_mine(int n) {

        if(n < 1){
            return false;
        }

        String str = Integer.toBinaryString(n);

        return str.lastIndexOf('1') == 0 && str.length() % 2 != 0;



    }


}
