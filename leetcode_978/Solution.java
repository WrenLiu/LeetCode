

public class Solution {

    public static void main(String[] args) {

        int[] arr = {4,5};
        System.out.println(maxTurbulenceSize(arr));

    }

    public static int maxTurbulenceSize_LeetCode(int[] arr) {
        
        int up = 1,down = 1;
        int maxCount = 1;

        for (int i = 1; i < arr.length; i++) {
            
            if(arr[i] > arr[i-1]){
                up = down + 1;
                down = 1;
            }else if(arr[i] < arr[i-1]){
                down = up + 1;
                up = 1;
            }else {
                up = down = 1;
            }
            
            maxCount = Math.max(maxCount,Math.max(up,down));            
        }
        
        return maxCount;

    }


    // 疯狂打补丁的方法
    public static int maxTurbulenceSize(int[] arr) {

        if(arr == null || arr.length == 0){
            return -1;
        }

        if(arr.length == 1){
            return 1;
        }

        if(arr.length == 2 && arr[1] != arr[0]){
            return 2;
        }

        int maxCount = 1;

        int left = 0,right = 1;
        int isBigger ; // >


        while(right < arr.length-1){

            // 9,4,2,10,7,8,8,1,9

            isBigger = arr[right] > arr[right-1] ? 1 : 0;

            if(isBigger == 1 && arr[right+1] < arr[right] ){

                right++;
                System.out.println("true "+left+" "+right);

            }else if(isBigger == 0 && arr[right+1] > arr[right]){

                right++;
                System.out.println("false "+left+" "+right);

            }else{

                left = right;
                right++;
            }

            if(right - left == 1 && arr[right] == arr[left]){
                continue;
            }

            maxCount = Math.max(maxCount,right - left+1);







        }





        return maxCount;



    }

}
