
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {

         char[][] maze = {{'.','+'}};
         int[] entrance = {0,0};

//        char[][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
//        int[] entrance = {1,2};


        System.out.println(nearestExit(maze , entrance));


    }


    /* bfs实现
     *
     */
    public static int nearestExit(char[][] maze, int[] entrance) {

        int row = maze.length;
        int col = maze[0].length;

        // 上下左右的变化量
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        Queue<int[]> queue = new ArrayDeque<>();
        int[] arrTmp = {entrance[0] , entrance[1] , 0};

        // 需要将走过的地方标记成 '+'
        maze[entrance[0]][entrance[1]] = '+';
        queue.add(arrTmp);

        while(!queue.isEmpty()){

            int[] front = queue.poll();

            for (int i = 0; i < 4; i++) {

                // 新坐标
                int nx = front[0] + dx[i];
                int ny = front[1] + dy[i];

                // 判断新坐标合法
                if(!(nx < 0 || nx >= row || ny < 0 || ny >= col || maze[nx][ny] == '+')){
                    if(nx == 0 || nx == row - 1 || ny == 0 || ny == col-1){
                        return front[2]+1;
                    }

                    maze[nx][ny] = '+';
                    int[] willBeAdd = {nx, ny , front[2]+1};
                    queue.add(willBeAdd);

                }


            }
        }

        return -1;





    }


    /*
     * dfs会出现栈溢出,还会超时

    static int res;
    static int row ,col;
    static int[] ent;
    static boolean[][] isOn;
    public static int nearestExit_mine(char[][] maze, int[] entrance) {

        row = maze.length;
        col = maze[0].length;

        ent = new int[2];
        ent[0] = entrance[0];
        ent[1] = entrance[1];

        res = Integer.MAX_VALUE;

        isOn = new boolean[row][col];


        dfs(maze , 0 , entrance[0] , entrance[1] );

        return res == Integer.MAX_VALUE  ? -1 : res ;


    }

    static void dfs(char[][] maze ,int curStep , int curX , int curY ){


        if( curStep >  res || curStep > 10000){
            return;
        }

        isOn[curX][curY] = true;


        System.out.println(curX+" "+curY+ " "+curStep);
        if(isOver(curX , curY)){
            res = Math.min(curStep , res);
            System.out.println("curStep"+curX+curY);
            return ;
        }


        if(curX+1 < row && !isOn[curX+1][curY] && maze[curX+1][curY] == '.'){
            dfs(maze, curStep+1, curX+1, curY);
        }
        if(curY+1 < col && !isOn[curX][curY+1] && maze[curX][curY+1] == '.'){
            dfs(maze, curStep+1, curX, curY+1);
        }
        if(curY-1 >= 0 && !isOn[curX][curY-1] && maze[curX][curY-1] == '.'){
            dfs(maze, curStep+1, curX, curY-1);
        }

        if(curX-1 >= 0 && !isOn[curX-1][curY] && maze[curX-1][curY] == '.'){
            dfs(maze, curStep+1, curX-1, curY);
        }




    }

    private static boolean isOver(int X ,int Y){

        if(X == ent[0] && Y == ent[1]){
            return false;
        }

        if(X == 0 || X == row-1 || Y == col-1 || Y == 0){
            return true;
        }else{
            return false;
        }

    }


     */
}
