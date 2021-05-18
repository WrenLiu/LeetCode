

public class Solution{


    public static void main(String[] args) {

        int[] arr = {2,3,1,6,7};

        System.out.println(countTriplets(arr));
    }

    public static int countTriplets(int[] arr) {

        if(arr == null){
            return 0;
        }

        int res = 0;
        int total ;

        for (int i = 0; i < arr.length ; i++) {

            total = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                total ^= arr[j];

                if(total == 0){
                    res += j - i;
                }
            }
        }

        return res;

    }


}
