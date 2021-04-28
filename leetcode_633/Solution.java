public class Solution {

    public static void main(String[] args) {

        System.out.println(judgeSquareSum(5));

    }


    /**
     * 费马平方和 : 奇质数能表示为两个平方数之和的充分必要条件是该质数被 4 除余 1
     * ==>  当且仅当一个自然数的质因数分解中，满足 4k+3 形式的质数次方数均为偶数时，该自然数才能被表示为两个平方数之和。
     */
    private static boolean judgeSquareSum(int c){

        for (int i = 2, cnt = 0; i * i <= c; i++, cnt = 0) {
            while (c % i == 0 && ++cnt > 0) c /= i;
            if (i % 4 == 3 && cnt % 2 != 0) return false;
        }
        return c % 4 != 3;

    }


    public static boolean judgeSquareSum_mine(int c) {

        if(c < 0){
            return false;
        }

        int leftIndex = 0, rightIndex = (int)Math.sqrt(c);

        while(leftIndex <= rightIndex){

            int cur = leftIndex * leftIndex + rightIndex * rightIndex;

            if(cur == c){
                return true;
            }else if(cur >  c){
                rightIndex -- ;
            }else{
                leftIndex ++;
            }

        }

        return false;
    }




}
