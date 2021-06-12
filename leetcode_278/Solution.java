
public class Solution {

    public static void main(String[] args) {

        System.out.println(firstBadVersion(2126753390));



    }

    private static boolean isBadVersion(int version){
        if(version >= 1702766719){
            return true;
        }else{
            return false;
        }
    }

    public static int firstBadVersion(int n) {

        if(n <= 0){
            return 0;
        }

        int left = 1 ,right  = n;
        while(left <= right){

            // 不然容易出界
            // low + (high - low) / 2;

            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }

        return left;


    }

}
