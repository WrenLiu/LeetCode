public class Solution {

    public static void main(String[] args) {

//        int[][] nums = {
//            {3, 0, 1, 4, 2},
//            {5, 6, 3, 2, 1},
//            {1, 2, 0, 1, 5},
//            {4, 1, 0, 1, 7},
//            {1, 0, 3, 0, 5}
//        };

        int[][] nums = {{-4,-5}};

        NumMatrix numMatrix = new NumMatrix(nums);

        System.out.println(numMatrix.sumRegion(0,0,0,1));
//        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
//        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
//        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));




    }


    public static class NumMatrix{

        int[][] matrix;
        int[][] dp;

        public NumMatrix(int[][] matrix) {
            if(matrix == null){
                return;
            }

            this.matrix = matrix;
            dp = new int[matrix.length][matrix[0].length];

            dp[0][0] = matrix[0][0];

            // 首行初始化
            for (int i = 1; i < matrix[0].length; i++) {

                dp[0][i] = dp[0][i-1] + matrix[0][i];
            }


            // 首列初始化
            for (int i = 1; i < matrix.length; i++) {
                dp[i][0] = dp[i-1][0] + matrix[i][0];
            }


            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] + matrix[i][j] - dp[i-1][j-1];
                }
            }

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    System.out.print(dp[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();





        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            if(row1 == 0 && col1 == 0){
                return dp[row2][col2];
            }

            if(row1 == row2 && col1 == col2){
                return matrix[row1][col1];
            }

            if(row1 == 0 && col1 != 0){
                return dp[row2][col2] - dp[row2][col1-1];
            }else if(row1 != 0 && col1 == 0){
                return dp[row2][col2] - dp[row1-1][col2];
            }


            return dp[row2][col2] - dp[row2][col1-1] - dp[row1-1][col2] + dp[row1-1][col1-1];

        }

    }



}
