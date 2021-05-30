
import java.util.*;

public class Solution {

    public static void main(String[] args) {


        int[][] grid = {{1,2,1,2,1,2,1,2,1,2}};



        System.out.println(Arrays.toString(getBiggestThree(grid)));


    }
    public static int[] getBiggestThree(int[][] grid) {


        if(grid == null){
            return null;
        }

        TreeSet<Integer> arrayList = new TreeSet<>();

        int row = grid.length;
        int col = grid[0].length;



        int maxLen = Math.min(row/2,col/2);

        for (int centerRow = 0; centerRow < row; centerRow++) {
            for (int centerCol = 0; centerCol < col; centerCol++) {

                arrayList.add(grid[centerRow][centerCol]);

                maxLen = Math.min(row -1 - centerRow  ,Math.min(col - 1 - centerCol , Math.min(centerCol,centerRow)));


                for (int r = 1; r <= maxLen; r++) {

                    int count = 0 ;
                    int X = centerRow - r , Y = centerCol;

                    // 第一条边
                    while(X >= 0 && Y >= 0 && X < row && Y < col){
                        if(X == centerRow && Y == centerCol + r){
                            break;
                        }
                        count += grid[X][Y];
                        X += 1;
                        Y += 1;
                    }


                    // 第二条边
                    while(X >= 0 && Y >= 0 && X < row && Y < col){
                        if(X == centerRow + r && Y == centerCol ){

                            break;
                        }
                        count += grid[X][Y];
                        X += 1;
                        Y -= 1;
                    }



                    // 第三条边
                    while(X >= 0 && Y >= 0 && X < row && Y < col){
                        if(X == centerRow  && Y == centerCol - r ){

                            break;
                        }
                        count += grid[X][Y];
                        X -= 1;
                        Y -= 1;
                    }

                    // 第四条边
                    while(X >= 0 && Y >= 0 && X < row && Y < col){
                        if(X == centerRow - r  && Y == centerCol ){
                            break;
                        }
                        count += grid[X][Y];
                        X -= 1;
                        Y += 1;
                    }

                    arrayList.add(count);






                }
                
                
                
                
            }
        }



        if(arrayList.size() < 3){
            int[] res = new int[arrayList.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = arrayList.pollLast();
            }

            return res;
        }


        int[] res = new int[3];

        res[0] = arrayList.pollLast();
        res[1] = arrayList.pollLast();
        res[2] = arrayList.pollLast();



        return res;



    }




}
