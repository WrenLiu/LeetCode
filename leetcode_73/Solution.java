
public class Solution {

    public static void main(String[] args) {

        int[][] ma = {{1,1,1}, {1,0,1}, {1,1,1}};
        setZeroes(ma);

    }

    public static void setZeroes(int[][] matrix) {

        if(matrix == null || matrix.length == 0){
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] is0 = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(matrix[i][j] == 0){
                    is0[i][j] = true;
                }
            }
        }

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                if(is0[i][j] == true){

                    for (int row = 0; row < rows; row++) {
                        matrix[row][j] = 0;

                    }
                    for (int col = 0; col < cols; col++) {
                        matrix[i][col] = 0;
                    }

                }

            }


        }



        
    }


}
