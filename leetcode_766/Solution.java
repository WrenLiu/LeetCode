

public class Solution {

    public static void main(String[] args) {


        int[][] matrix =  {{1,2},{2,2}};
        System.out.println(isToeplitzMatrix(matrix));


    }

    public static boolean isToeplitzMatrix(int[][] matrix) {

        if(matrix == null || matrix.length == 0 ){
            return false;
        }else if(matrix.length == 1){
            return true;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int col = 0; col < cols; col++) {
            int tmpCol = col;
            int tmpRow = 0;

            int number = matrix[tmpRow][tmpCol];
            while(tmpCol < cols && tmpRow < rows){
                if(matrix[tmpRow++][tmpCol++] != number){
                    return false;
                }

            }

        }

        for (int row = 1; row < rows; row++) {

            int tmpCol = 0;
            int tmpRow = row;

            int number = matrix[tmpRow][tmpCol];

            while(tmpCol < cols && tmpRow < rows){
                if(matrix[tmpRow++][tmpCol++] != number){
                    return false;
                }

            }
        }



        return true;

    }


}
