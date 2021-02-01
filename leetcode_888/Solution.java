

import java.util.Arrays;

public class Solution888 {

    public static void main(String[] args) {
        int[] A = {1,1};
        int[] B = {2,2};
        System.out.println(Arrays.toString(fairCandySwap(A,B)));

    }

    public static int[] fairCandySwap(int[] A, int[] B) {

        int[] ans = new int[2];
        Arrays.sort(A);
        Arrays.sort(B);


        int sumA = 0;
        int sumB = 0;
        for (int i : A) {
            sumA += i;
        }

        for (int i : B) {
            sumB += i;
        }

        int indexA = 0,indexB = 0;
        while(indexA < A.length && indexB < B.length){





            if ((sumA + B[indexB] - A[indexA]) > ( sumB + A[indexA] -B[indexB]) ){
                indexA ++;
                continue;
            }else if((sumA + B[indexB] - A[indexA]) < ( sumB + A[indexA] -B[indexB]) ){
                indexB++;
                continue;
            }else {
                return new int[]{A[indexA],B[indexB]};
            }




        }








        return ans;


    }


}
