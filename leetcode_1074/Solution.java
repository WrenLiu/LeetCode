
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        int[][] matrix = {{904}};

        int target = 0;

        System.out.println(numSubmatrixSumTarget(matrix , target));

    }
    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) { // 枚举上边界
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) { // 枚举下边界
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c]; // 更新每列的元素和
                }
                ans += subarraySum(sum, target);
            }
        }
        return ans;
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int count = 0, pre = 0;
        for (int x : nums) {
            pre += x;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
    public static int numSubmatrixSumTarget_Vio(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0){
            return 0;
        }

        int count = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] preSum =  new int [rows+1][cols+1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] - preSum[i-1][j-1] + matrix[i-1][j-1];
            }
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                for (int m = 1; m <= i; m++) {
                    for (int n = 1; n <= j; n++) {

                        if(target == preSum[i][j] + preSum[m-1][n-1] - preSum[m-1][j] - preSum[i][n-1]){
                            count++;
                        }


                    }
                }
            }
        }


        return count;
    }



}
