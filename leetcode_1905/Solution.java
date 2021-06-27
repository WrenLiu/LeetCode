
public class Solution {


    static boolean visited[][];
    static int rows , cols;

    static int res;
    static boolean flag;

    public static void main(String[] args) {

        int[][] grid1 =  {{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 =  {{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}};

        System.out.println(countSubIslands(grid1, grid2));
    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {

        if(grid1 == null || grid2 == null || grid1.length != grid2.length || grid1[0].length != grid2[0].length){
            return 0;
        }

        rows = grid1.length;
        cols = grid1[0].length;

        visited = new boolean[rows][cols];
        res = 0;
        flag = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                flag = false;
                if(visited[i][j] == false && grid2[i][j] == 1 && grid1[i][j] == 1){
                    flag = true;
                    dfs(grid1 , grid2 , i , j);
                }

                if(flag == true){
                    res++;
                }
            }
        }

        return res;
    }

    private static void dfs(int[][] grid1 , int[][] grid2 ,int curRow , int curCol){

        if( curRow < 0 || curRow >= rows || curCol < 0 || curCol >= cols ||
                visited[curRow][curCol] == true || grid2[curRow][curCol] == 0){
            return;
        }


        visited[curRow][curCol] = true;

        if(grid1[curRow][curCol] == 0){
            flag = false;
        }

        dfs(grid1 , grid2 , curRow+1 ,curCol) ;
        dfs(grid1 , grid2 , curRow-1 ,curCol) ;
        dfs(grid1 , grid2 , curRow ,curCol+1) ;
        dfs(grid1 , grid2 , curRow ,curCol-1) ;

    }

}
