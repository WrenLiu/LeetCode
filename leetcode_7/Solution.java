public class Solution {

    public static void main(String[] args) {

        System.out.println(reverse(-2147483648));

    }


    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            if (x > 0 && ans > (Integer.MAX_VALUE - x % 10) / 10) return 0;
            if (x < 0 && ans < (Integer.MIN_VALUE - x % 10) / 10) return 0;
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return ans;

    }

    public static int reverse_Mine(int x) {

        if(x == 0 || x == Integer.MIN_VALUE){
            return 0;
        }


        boolean isFushu = false;
        if(x < 0){
            x = -x;
            isFushu = true;

        }

        String strRes = new StringBuffer(x+"").reverse().toString();

        System.out.println(strRes);

        long res = Long.parseLong(strRes);
        if(res > Integer.MAX_VALUE){
            return 0;
        }

        int resInt = Integer.parseInt(strRes);


        return isFushu ? resInt * -1 :  resInt;




    }



}
