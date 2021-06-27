
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Solution {


    static int n;
    static int[] nums;
    public static void main(String[] args) {

        int[][] board = {{-1,-1,-1,-1,-1,-1},
                         {-1,-1,-1,-1,-1,-1},
                         {-1,-1,-1,-1,-1,-1},
                         {-1,35,-1,-1,13,-1},
                         {-1,-1,-1,-1,-1,-1},
                         {-1,15,-1,-1,-1,-1}};

        System.out.println(snakesAndLadders(board));

    }

    public static int snakesAndLadders(int[][] board) {

        if(board == null){
            return 0;
        }

        n = board.length;
        if(board[0][0] != -1) return -1;

        nums = new int[n * n +1];
        boolean isRight = true;

        // 转换成为一维数组
        for (int i = n-1 ,idx = 1; i >= 0 ; i--) {
            for (int j = (isRight ? 0 : n-1); isRight ? j < n : j >= 0; j += isRight ? 1 : -1) {
                nums[idx++] = board[i][j];
            }
            isRight = !isRight;
        }

        return bfs();
    }

    private static int bfs(){
        Deque<Integer> deque = new ArrayDeque<>();

        HashMap<Integer,Integer> map = new HashMap<>();

        deque.addLast(1);
        map.put(1, 0);

        while(!deque.isEmpty()){
            int poll = deque.pollFirst();

            int step = map.get(poll);
            if(poll == n * n) return step;

            for (int i = 1; i <= 6; i++) {
                int np = poll + i;
                if(np <= 0 || np > n*n) continue;

                if(nums[np] != -1) np = nums[np];
                if(map.containsKey(np)) continue;

                map.put(np , step+1);
                deque.addLast(np);
            }

        }

        return -1;

    }


}
