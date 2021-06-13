
public class Solution {

    public static void main(String[] args) {

        int[][] grid = {{5,1,3,1},{9,3,3,1},{1,3,3,8}};

//        System.out.println(isOk02(grid ,1,1, 2));


        System.out.println(largestMagicSquare(grid));



    }

    private static boolean isOk02(int[][] grid , int row , int col , int k){


        int total = 0;
        // 先判断对角线
        for (int i = 0; i < k; i++) {
            total += grid[row + i][col + i];
        }

        int total02 = 0;
        int newCol = col + k -1;
        for (int i = 0; i < k; i++) {
            total02 += grid[row + i][newCol - i];
        }

        if(total02 != total){
            return false;
        }


        // 横向判断
        for (int i = 0; i < k; i++) {

            total02 = 0;
            for (int j = 0; j < k; j++) {
                total02 += grid[row + i][col + j];
            }

            if(total02 != total) {
                return false;
            }

        }

        // 纵向判断
        for (int i = 0; i < k; i++) {
            total02 = 0;
            for (int j = 0; j < k; j++) {
                total02 += grid[row + j][col + i];
            }
            if(total02 != total) {
                return false;
            }
        }

        return true;

    }

    private static boolean isOk(int[][] grid , int row , int col , int k){

        int total = 0;

        // 先判断对角线
        total = grid[row][col];
        for (int i = 1; i <= k; i++) {
            total += grid[row + i][col + i];
            total += grid[row - i][col - i];
        }

        int total01 = 0;
        //
        total01 = grid[row][col];
        for (int i = 1; i <= k; i++) {
            total01 += grid[row - i][col + i];
            total01 += grid[row + i][col - i];
        }

        if(total01 != total){
            return false;
        }

        // 判断横向
        total01 = 0;
        for (int i = -k; i <= k ; i++) {
            total01 = 0;
            for (int j = -k; j <= k ; j++) {
                total01 += grid[row + i][col + j];
            }

            if(total01 != total){
                return false;
            }
        }

        // 判断纵向
        for (int i = -k; i <= k ; i++) {
            total01 = 0;
            for (int j = -k; j <= k ; j++) {
                total01 += grid[row + j][col + i];
            }

            if(total01 != total){
                return false;
            }
        }


        return true;


    }
    public static int largestMagicSquare(int[][] grid) {

        if(grid == null)
            return 0;

        int res = 1;
        int k = 1;
        int center = 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int total = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {


                k = 1;
                while(i + k < rows && i - k >= 0 && j + k < cols && j - k >= 0){

                    if(isOk(grid , i , j , k)){
                        res = Math.max(res , 2 * k + 1);
                    }

                    k++;

                }

                k = 2;
                while(i + k - 1 < rows && j + k -1 < cols){

                    if(isOk02(grid , i , j ,k)){
                        res = Math.max(res , k);
                    }

                    k += 2;
                }





            }



        }





        return res;



    }

}
