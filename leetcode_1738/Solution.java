
import java.util.Arrays;

public class Solution1738 {

    public static void main(String[] args) {

        int[][] matrix =  {{8,10,5,8,5,7,6,0,1,4,10,6,4,3,6,8,7,9,4,2}};

        System.out.println(kthLargestValue(matrix , 2));

    }

    public static int kthLargestValue(int[][] matrix, int k) {

        if(matrix == null){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] nums = new int[m][n];
        int[] arr = new int[m*n];
        int index = 0;

        nums[0][0] = matrix[0][0];
        arr[index++] = nums[0][0];
        for (int i = 1; i < n; i++) {
            nums[0][i] = nums[0][i-1] ^ matrix[0][i];
            arr[index++] = nums[0][i];
        }
        for (int i = 1; i < m; i++) {

            nums[i][0] = nums[i-1][0] ^ matrix[i][0];
            arr[index++] = nums[i][0];

        }

//        sum[i][j]=sum[i−1][j] ⊕ sum[i][j−1] ⊕ sum[i−1][j−1] ⊕ matrix[i−1][j−1]

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                nums[i][j] = nums[i-1][j] ^ nums[i][j-1] ^ nums[i-1][j-1] ^ matrix[i][j];
                arr[index++] = nums[i][j];
            }
        }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));





        return arr[arr.length-k];

    }




}
