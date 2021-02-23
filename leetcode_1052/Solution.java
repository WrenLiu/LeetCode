

public class Solution {


    public static void main(String[] args) {

        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};

        System.out.println(maxSatisfied(customers,grumpy,3));

    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {

        if(customers == null || grumpy == null || customers.length != grumpy.length){
            return -1;
        }

        int left = 0 ,right = left+X-1;
        int maxNum0 = 0;

        int len = customers.length;

        for (int i = 0; i < len; i++) {
            if(grumpy[i] == 0){
                maxNum0 += customers[i];
            }
        }

        int totalWindows = 0;

        for (int i = left; i < right+1; i++) {
            if(grumpy[i] == 1){
                totalWindows += customers[i];
            }
        }

        int maxWindows = totalWindows;
        right ++;

        while(right < len) {

            if (grumpy[right] == 1) {
                totalWindows += customers[right];
            }
            if (grumpy[left] == 1) {
                totalWindows -= customers[left];
            }

            maxWindows = Math.max(maxWindows, totalWindows);


            right++;
            left++;


        }


        return maxWindows+maxNum0;


    }


}
