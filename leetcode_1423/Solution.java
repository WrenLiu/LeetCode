

public class Solution {

    public static void main(String[] args) {


        int[] cardPoints = {1,79,80,1,1,1,200,1};
        int k = 3;

//        cardPoints = new int[]{1, 2, 3, 4, 5, 6, 1};
//        k = 3;
        System.out.println(maxScore(cardPoints,k));

    }

    public static int maxScore(int[] cardPoints, int k) {

        if(cardPoints == null || cardPoints.length == 0 || k <= 0 || k>cardPoints.length){
            return 0;
        }


        // 递归算法超时
//        int indexLeft = 0,indexRight = cardPoints.length-1;
//        int solution01 = helper01(cardPoints,indexLeft,indexRight,k);
        int len = cardPoints.length;
        int indexLeft = len-1,indexRight = k-1;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        max = sum;

        while(indexLeft > len - k && indexRight >= 0){
            sum += cardPoints[indexLeft];
            sum -= cardPoints[indexRight];
            indexLeft--;
            indexRight--;
            max = Math.max(max,sum);

        }
        max = Math.max(max,sum - cardPoints[0] + cardPoints[len-k]);


        return max;




    }

    private static int helper01(int[] card,int left,int right,int k){

        if( k == 1){
            return Math.max(card[left],card[right]);
        }

        int removeLeft = card[left] + helper01(card,left+1,right,k-1);
        int removeRight = card[right] + helper01(card,left,right-1,k-1);
        return Math.max(removeLeft,removeRight);

    }
}
