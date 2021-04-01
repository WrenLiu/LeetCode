
public class Solution {

    public static void main(String[] args) {

        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int[][] matrix = {{1},{3}};
        int target = 16;

        System.out.println(searchMatrix(matrix,target));



    }
    
    public static boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null){
            return false;
        }

        int row = 0 , col = matrix[0].length-1;

        // 需要从右上角或者左下角开始遍历矩阵
        while( row < matrix.length && col >= 0){

            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                row++ ;
            }else if(matrix[row][col] > target){
                col --;
            }

        }

        return false;



    }

}
