public class Solution {



    private static int res ;
    private static int m , n , target;
    private static int[] houses;
    private static int[][] cost;

    public static void main(String[] args) {

        int[] houses = {0,0,0,0,0};
        int[][] cost = {{1,10},{10,1},{10,1},{1,10},{5,1}};
        int m = 5, n = 2, target = 3;

        System.out.println(minCost_dfs(houses,cost,m,n,target));
        System.out.println(minCost(houses,cost,m,n,target));
    }

    // DP,可参考DFS
    private static int INF = 0x3f3f3f3f;
    public static int minCost(int[] hs, int[][] cost, int m, int n, int t) {
        int[][][] f = new int[m + 1][n + 1][t + 1];

        // 不存在分区数量为 0 的状态
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                f[i][j][0] = INF;
            }
        }

        for (int i = 1; i <= m; i++) {
            int color = hs[i - 1];
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= t; k++) {
                    // 形成分区数量大于房子数量，状态无效
                    if (k > i) {
                        f[i][j][k] = INF;
                        continue;
                    }

                    // 第 i 间房间已经上色
                    if (color != 0) {
                        if (j == color) { // 只有与「本来的颜色」相同的状态才允许被转移
                            int tmp = INF;
                            // 先从所有「第 i 间房形成新分区」方案中选最优（即与上一房间颜色不同）
                            for (int p = 1; p <= n; p++) {
                                if (p != j) {
                                    tmp = Math.min(tmp, f[i - 1][p][k - 1]);
                                }
                            }
                            // 再结合「第 i 间房不形成新分区」方案中选最优（即与上一房间颜色相同）
                            f[i][j][k] = Math.min(f[i - 1][j][k], tmp);

                        } else { // 其余状态无效
                            f[i][j][k] = INF;
                        }

                        // 第 i 间房间尚未上色
                    } else {
                        int u = cost[i - 1][j - 1];
                        int tmp = INF;
                        // 先从所有「第 i 间房形成新分区」方案中选最优（即与上一房间颜色不同）
                        for (int p = 1; p <= n; p++) {
                            if (p != j) {
                                tmp = Math.min(tmp, f[i - 1][p][k - 1]);
                            }
                        }
                        // 再结合「第 i 间房不形成新分区」方案中选最优（即与上一房间颜色相同）
                        // 并将「上色成本」添加进去
                        f[i][j][k] = Math.min(tmp, f[i - 1][j][k]) + u;
                    }
                }
            }
        }

        // 从「考虑所有房间，并且形成分区数量为 t」的所有方案中找答案
        int ans = INF;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, f[m][i][t]);
        }
        return ans == INF ? -1 : ans;
    }





    public static int minCost_dfs(int[] _houses, int[][] _cost, int _m, int _n, int _target) {

        if(_houses == null || _houses.length != _cost.length || _cost.length == 0){
            return 0;
        }

        if(_target > _houses.length){
            return -1;
        }

        res = Integer.MAX_VALUE;
        cost = _cost;
        houses = _houses;
        m = _m;
        n = _n;
        target = _target;

        helper(0, -1, 0 , 0);

        return res == Integer.MAX_VALUE ? -1 : res;

    }


    // curIndex : 当前处理到的房间编号
    // lastColor: 当前处理的房间颜色
    // curPartition : 当前形成的分区数量
    // curMoney : 当前的上色成本
    private static void helper(int curIndex,  int lastColor , int curPartition , int curMoney){

        // 越界
        if(curMoney > res || curPartition > target){
            return;
        }

        // 处理到最后的一个房间号
        if(curIndex == m){
            if(curPartition == target){
                res = Math.min(res , curMoney);
            }
            return;
        }

        int curColor = houses[curIndex];

        if(curColor == 0){

            // 未涂颜色，每个颜色轮流测试

            // i 是颜色的序号, 总共有 n - 1 种颜色的选择
            for (int color = 1; color <= n; color++) {
                int nCnt = curIndex - 1 < 0 ? 1 : ( lastColor == color ? curPartition : curPartition + 1 );
                helper(curIndex + 1, color, nCnt, curMoney + cost[curIndex][color - 1]);
            }

        }else{

            // 已经涂了颜色了
            //                                    查看当前颜色与上一个颜色是否相同
            int nCnt = curIndex - 1 < 0 ? 1 : ( lastColor == curColor ? curPartition : curPartition + 1 );
            helper(curIndex + 1, curColor, nCnt, curMoney);

        }




    }



}
