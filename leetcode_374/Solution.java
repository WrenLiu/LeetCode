

public class Solution {

    public static void main(String[] args) {

        System.out.println(guessNumber(2));

    }

//    int guess(int num);
    private static int guess(int num){
        if(num < 2){
            return 1;
        }else if(num > 2){
            return -1;
        }else{
            return 0;
        }

    }

    public static int guessNumber(int n) {

        if(n < 0){
            return 0;
        }

        int left = 0 , right = n;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(guess(mid) > 0 ){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(right);

        return left;

    }



}
