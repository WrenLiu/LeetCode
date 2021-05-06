import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] arr = {100,1,1000};

        System.out.println(maximumElementAfterDecrementingAndRearranging(arr));

    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        if(arr == null){
            return 0;
        }
        Arrays.sort(arr);

        arr[0] = 1;


        for (int i = 1; i < arr.length; i++) {

            arr[i] = Math.min(arr[i] , arr[i-1]+1);


        }


        return arr[arr.length-1];




    }

    public static int maximumElementAfterDecrementingAndRearranging_mine(int[] arr) {

        if(arr == null){
            return 0;
        }

//        arr 中 第一个 元素必须为 1 。
//        任意相邻两个元素的差的绝对值 小于等于 1 ，也就是说，对于任意的 1 <= i < arr.length
//        （数组下标从 0 开始），都满足 abs(arr[i] - arr[i - 1]) <= 1 。abs(x) 为 x 的绝对值。

        Arrays.sort(arr);

        int leftIndex = 0 ,rightIndex = 1;

        if(arr[0] != 1){
            arr[0] = 1;
        }

        while(rightIndex < arr.length){

            if (Math.abs(arr[rightIndex] - arr[leftIndex]) > 1 ){


                arr[rightIndex]  = arr[leftIndex] + 1 ;
            }
            rightIndex ++;
            leftIndex ++;


        }

        System.out.println(Arrays.toString(arr));


        return arr[arr.length-1];

    }
}
