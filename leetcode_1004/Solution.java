public class Solution {

    public static void main(String[] args) {

//        int[] A = {1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1};
//        System.out.println(longestOnes(A,8));


//        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
//        System.out.println(longestOnes(A,2));

        int[] A = {0,0,0,0};
//        System.out.println(longestOnes(A,3));

        System.out.println(longestOnes02(A,0));


//        System.out.println(A.length);



    }

    public static int longestOnes(int[] A, int K) {

        if(A == null || A.length < K){
            return -1;
        }

        int count = 0,max = 0;

        int left = 0 ,right = 0;


        while( right< A.length ){

            if((A.length - left) < max){
                break;
            }
            count = 0;

            while( right < A.length){
                if(A[right] == 0 ){
                    count ++;
                    if(count > K){
                        break;
                    }
                }

                right++;

            }

            max = Math.max(max,right - left  );

            left++;
            right = left;


        }



        return max;
    }


    public static int longestOnes02(int[] A, int K) {

        if(A == null || A.length < K){
            return -1;
        }

        int count = 0,max = 0;

        int left = 0 ,right = 0;

        while( right < A.length){

            if((A.length - left) < max){
                break;
            }

            if(A[right] == 0 ){
                count ++;
            }

            while(count > K && left <= right){

                if(A[left] == 0 ){
                    count -- ;

                }
                left++;

            }

            right++;
            max = Math.max(max,right- left);


        }





        return max;
    }


}
