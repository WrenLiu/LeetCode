public class Solution {

    public static void main(String[] args) {

        int n = 10, start = 5;
        System.out.println(xorOperation(n,start));

    }

    // 8
    public static int xorOperation(int n, int start) {

        if(n <= 0){
            return 0;
        }

        int ans = start;
        int index = 1;

        while(index < n){


            start +=  2;
            index++;
            ans ^= start;

        }

        return ans;


    }



}
