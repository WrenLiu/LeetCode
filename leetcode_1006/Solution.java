

public class Solution {

    public static void main(String[] args) {

//        System.out.println(clumsy(3));

        System.out.println(clumsy_leetcode(10));

    }

    private static int clumsy_leetcode(int N){

        if( N <= 2){
            return N;
        }else if( N == 3){
            return 6;
        }
        int sum = N * (N-1) / (N-2) + N -3;
        N -= 4;
        while( N >= 4){

            sum += ( -N * (N-1) / (N-2) + N -3 );
            N -= 4;
        }

        return sum - clumsy_leetcode(N);
    }

    public static int clumsy(int N) {

        int total = 0;

        if(N  == 1){
            return 1;
        }else if(N == 2){
            return 2;
        }else if(N  == 3){
            return 6;
        }

        if(N > 3){
            total = N * (--N) / (--N);
        }


        while(N > 0){


            if(N > 4){
                total += --N;
                total -= --N * (--N) / (--N);
            }else{
                break;
            }


        }

        N--;

        if(N == 0){
            return total;
        }
        int tmp01 = N-- ;


        if(N == 0){
            return total + tmp01;
        }
        int tmp02 = N-- ;


        boolean isCheng = true;
        while(N > 0){

            if(isCheng){
                tmp02 *= N--;
                isCheng = false;
            }else {
                isCheng = true;
                tmp02 /= N--;
            }

        }

        return total + tmp01 - tmp02;






    }




}
