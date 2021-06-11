

public class Solution {

    public static void main(String[] args) {

        System.out.println(numSquares(7));
    }
    public static int numSquares(int _n) {

//      四平方定理： 任何一个正整数都可以表示成不超过四个整数的平方之和, 也就是结果只有可能是 1,2,3,4
//      推论：满足四数平方和定理的数n（四个整数的情况），必定满足 n=4^a(8b+7)


        if(_n <= 0){
            return 0;
        }

        // 当结果是4时 , 必定满足 n=4^a(8b+7)
        int n = _n;

        while(n % 4 == 0){
            n /= 4;
        }

        if(n % 8 == 7){
            return 4;
        }

        // 当结果是1的时候,必定能正好被开平方
        int a = (int)Math.sqrt(_n);

        if(a * a == _n){
            return 1;
        }

        // 当结果是2的时候,必定满足 _n = a * a + b * b
        int b = 1;

        while(b <= a){
            int c = (int ) Math.sqrt(_n - b * b);
            if(c * c + b * b == _n ){
                return 2;
            }
            b++;
        }

        // 上边都不满足结果就是3
        return 3;





    }



}
