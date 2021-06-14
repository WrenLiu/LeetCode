
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] arr = {3,5,3,2,0};
        System.out.println(peakIndexInMountainArray(arr));

    }

    public static int peakIndexInMountainArray(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }

        int leftIndex = 0 , rightIndex = arr.length - 1;
        int len = arr.length;

        int midIndex = -1;
        while(leftIndex <= rightIndex){

            midIndex = leftIndex + (rightIndex - leftIndex) / 2;

            System.out.println(midIndex);


            if(midIndex > 0 && midIndex < len-1 &&
                    arr[midIndex] >= arr[midIndex+1] && arr[midIndex] >= arr[midIndex-1]){
                return midIndex;
            }

            if(midIndex > 0 && arr[midIndex] <= arr[midIndex-1] ){
                rightIndex = midIndex - 1;
            }else{
                leftIndex = midIndex + 1;
            }


        }

        return  midIndex;




    }

    public static int peakIndexInMountainArray_Mine(int[] arr) {

        if(arr == null || arr.length == 0){
            return 0;
        }

        int[] arr_new = Arrays.copyOf(arr,arr.length);

        Arrays.sort(arr_new);

        int peekNum = arr_new[arr.length-1];

        int index = 0;
        while(peekNum != arr[index]){
            index++;
        }

        return index;




    }



}
