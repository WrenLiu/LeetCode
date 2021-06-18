
public class Solution {

    public static void main(String[] args) {

//        System.out.println(Long.MAX_VALUE);

        System.out.println(smallestGoodBase("1000000000000000000"));
    }

    private static boolean isOk(long num , long n){

        while(num > 0 ){

            if(num % n != 1){
                return false;
            }
            num /= n;

        }
        return true;

    }

    public static String smallestGoodBase(String n) {


        // n = k^0 + k^1 + k^2 + ... + k^m
        // ==> 结论1 : m<logk(n)
        // ==> 结论2 : k = sqrt(m,n)


        if(n == null){
            return null;
        }

        long num = Long.parseLong(n);

        int maxNum = (int)Math.floor(Math.log(num) / Math.log(2));

        for (int m = maxNum; m > 1 ; m--) {
            int k = (int)Math.pow(num , 1.0 / m);
            if(isOk(num , k)){
                return k +"";
            }
        }
        

        return (num-1)+"";

    }

}
