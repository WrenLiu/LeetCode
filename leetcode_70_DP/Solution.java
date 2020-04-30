class Solution {
    public int climbStairs(int n) {

        int[] arr = new int[n+1];
        return climb(n, arr);
    }

    private int climb(int n , int[] arr){

        arr[0] = 1;
        arr[1] = 1;
        
        // 爬楼梯问题，动态规划解决
        for(int i =2;i<=n ;i++){
            arr[i] = arr[i-1]+arr[i-2];
        }

        return arr[n];
    }
}