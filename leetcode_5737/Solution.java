
public class Solution {

    public static void main(String[] args) {

        int[] arr1 = {1,2,3};
        int[] arr2 = {6,5};
        System.out.println(getXORSum(arr1,arr2));

    }

    public static int getXORSum(int[] arr1, int[] arr2) {

        if(arr1 == null || arr2 == null){
            return 0;
        }

//      (a&b) ^ (a&c) => a&(b^c)

        int res = 0;

        int arr1_XOR_Sum = arr1[0];
        for (int i = 1; i < arr1.length; i++) {
            arr1_XOR_Sum ^= arr1[i];
        }

        int arr2_XOR_Sum = arr2[0];
        for (int i = 1; i < arr2.length; i++) {
            arr2_XOR_Sum ^= arr2[i];
        }


        return arr1_XOR_Sum & arr2_XOR_Sum;

    }


}
