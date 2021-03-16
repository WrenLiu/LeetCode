

public class Solution {

    public static void main(String[] args) {

        int[][] res = generateMatrix(5);



    }
    public static int[][] generateMatrix(int n) {

        if(n < 0){
            return null;
        }

        int[][] result = new int[n][n];
        if(n == 0){
            return result;
        }else if(n == 1){
            result[0][0] = 1;
            return result;
        }


        int index = 0;
        int num = 1;
        while(index < (n % 2 == 1 ? n/2+1 : n/2 )){

            num = helper(result,index,n,num);
            index ++;


        }




        return result;


    }

    private static int helper(int[][] res ,int index,int n,int num){

        int row = index,col = index;
        System.out.println(index);

        while(col < n-index ){
            res[row][col++] = num++;
        }

        row ++;
        col--;
        while(row < n-index){
            System.out.println(row);
            res[row++][col] = num++;
        }

        row--;
        col--;
        while(col >= index){
            res[row][col--] = num++;
        }



        row--;
        col++;
        while(row > index){
            res[row--][col] = num++;
        }




        return num;




    }

}
