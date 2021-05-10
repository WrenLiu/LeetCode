public class Solution {

    public static void main(String[] args) {

        System.out.println(sumBase(34,6));

    }

    public static int sumBase(int n, int k) {

        if(n <= 0 || k < 0){
            return 0;
        }


        int count = 0;
        while(n > 0 ){
            count += n % k;
            n /= k;
        }


        return count;



    }


}
