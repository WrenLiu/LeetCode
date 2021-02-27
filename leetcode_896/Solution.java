

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,1,1};

        System.out.println(isMonotonic(nums));

    }

    public static boolean isMonotonic(int[] A) {

        if(A == null || A.length == 0){
            return false;
        }else if(A.length == 1){
            return true;
        }

        // 单增
        int flag = 1;

        for (int i = 1; i < A.length; i++) {

            if(A[i] == A[i-1]){
                continue;
            }

            flag = A[i] > A[i-1] ? 1 : 0;
            break;

        }

        for (int i = 1; i < A.length; i++) {

            if(A[i] >= A[i-1] && flag == 1){
                continue;
            }else if(A[i] <= A[i-1] && flag == 0){
                continue;
            }else {
                return false;
            }

        }


        return true;

    }


}
