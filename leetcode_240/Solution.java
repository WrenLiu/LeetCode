
public class Solution{

    public static void main(String[] args) {

        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

        System.out.println(findNumberIn2DArray(matrix,5));

    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        if(matrix == null){
            return false;
        }

        int rows = matrix.length, cols = matrix[0].length;

        int row = 0 , col = cols -1;


        while(row < rows && col >= 0){

            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                row++;
            }else if(matrix[row][col] > target){
                col--;
            }

        }






        return false;

    }


}
