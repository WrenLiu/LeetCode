

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[][] nums = {{1,1,0},{1,0,1},{0,0,0}};
        int[][] res = flipAndInvertImage(nums);

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));

        }
        
    }

    public static  int[][] flipAndInvertImage(int[][] A) {

        if(A == null || A.length != A[0].length){
            return null;
        }

        int len = A.length;
        int[][] res = new int[len][len];

        for(int i = 0;i<len ; i++){

            for(int j = 0;j<len/2;j++){
                res[i][len-j-1] = 1-A[i][j];
                res[i][j] = 1-A[i][len-j-1] ;
            }

            if(len % 2 == 1){
                res[i][len/2] = 1-A[i][len/2];
            }

        }

        return res;



    }
}
