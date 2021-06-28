
import java.util.ArrayList;
import java.util.Arrays;

public class Solution{

    static int rows , cols;

    private static int[][] res;
    public static void main(String[] args) {


//        int[][] grid = {{40,10},{30,20}};

        int[][] grid = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};


        int[][] res = rotateGrid(grid , 100);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }




    }
    public static int[][] rotateGrid(int[][] grid, int k) {

        if(grid == null){
            return null;
        }

        rows = grid.length;
        cols = grid[0].length;

        int layers = Math.min(rows / 2 , cols / 2);

        res = new int[rows][cols];

        for (int i = 0; i < layers; i++) {

            ArrayList<Integer> newArr = new ArrayList<>();
            getArr(grid , i , newArr);

            int[] movedArr = moveArr(newArr , k);




            pushOnGrid(i , movedArr);




        }




        return res;
    }

    private static int[] moveArr(ArrayList<Integer> newArr , int k){

        int[] res = new int[newArr.size()];

        int size = newArr.size();

        for (int i = 0; i < size; i++) {

            int pos = i;
            if(pos + k >= size){

                pos = (pos + k ) % size;
//                pos = pos + k - size + 0;
            }else{
                pos = pos + k;
            }

            res[pos] = newArr.get(i);


        }

        return res;


    }

    private static void pushOnGrid(int layer , int[] movedArr){


        int index = 0;
        for (int i = layer; i < rows - layer; i++) {

            res[i][layer] = movedArr[index++];


        }


        for (int i = layer+1; i < cols - layer; i++) {
            res[rows - layer - 1][i] = movedArr[index++];
        }


        for (int i = rows-layer-2; i >= layer ; i--) {

            res[i][cols - layer -1 ] = movedArr[index++];
        }


        for (int i = cols - layer -2; i > layer ; i--) {

            res[layer][i] = movedArr[index++];
        }


    }

    private static void getArr(int[][] grid , int layer , ArrayList<Integer> res){


        for (int i = layer; i < rows - layer; i++) {
            res.add(grid[i][layer]);
//            System.out.print(grid[i][layer]+" ");

        }


        for (int i = layer+1; i < cols - layer; i++) {
            res.add(grid[rows - layer - 1][i]);
//            System.out.print(grid[rows - layer - 1][i]+" ");
        }


        for (int i = rows-layer-2; i >= layer ; i--) {

            res.add(grid[i][cols - layer -1 ]);
//            System.out.print(grid[i][cols - layer-1]+" ");
        }


        for (int i = cols - layer -2; i > layer ; i--) {
            res.add(grid[layer][i]);
//            System.out.print(grid[layer][i]+" ");
        }






    }


}
