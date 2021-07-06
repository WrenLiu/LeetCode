public class Solution {

    public static void main(String[] args) {

        int n = 1924;
        System.out.println(countGoodNumbers(n));

        System.out.println("--------");
        System.out.println(countGoodNumbers_mine(n));



    }
    static final int MODULE  = 1000000007;

    // 快速幂
    private static long qmi(long a , long b){

        long res = 1;
        while(b > 0){
            if((b & 1) == 1) res = a * res % MODULE;
            a = a * a % MODULE;
            b >>= 1;
        }
        return res;

    }

    public static int countGoodNumbers(long n) {



        if(n == 1) return 5;

        return (int)qmi(5, (n+1) / 2) *  (int)qmi(4 , n/2) % MODULE;


    }


    // 超时
    public static int countGoodNumbers_mine(long n) {

        final int MODULE = 1000000007;
        long res = 1;

        int odd = 0;
        int oushu = 0;

        for (int i = 0; i < n; i++) {

            if(i % 2 == 0){

                res = res * 5;
                oushu++;

            }else {
                odd++;
                res = res * 4;
            }

            res = res % MODULE;
        }

        System.out.println(odd+" "+oushu);

        return (int)(res % MODULE);

    }



}
