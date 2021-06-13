
public class Solution {

    public static void main(String[] args) {


        int[][] arr = {{1,2},{3,4},{5,6}};

        int  left = 2, right = 5;
        System.out.println(isCovered(arr , left , right));


    }

    public static boolean isCovered(int[][] ranges, int left, int right) {

        if(ranges == null || ranges.length == 0){
            return false;
        }

        int len = ranges.length;
        for (int x = left; x <= right ; x++) {

            boolean flag = false;
            for (int i = 0; i < len; i++) {
                if(ranges[i][0] <=x && ranges[i][1] >= x){
                    flag = true;
                    break;
                }

            }

            if(!flag){
                return false;
            }



        }

        return true;

    }



}
