
public class Solution {

    public static void main(String[] args) {


        System.out.println(countTriples(11));


    }


    public static int countTriples(int n) {

        if(n < 5){
            return 0;
        }

        int res = 0;
        for (int a = 1; a <= n; a++) {

            for (int b = 1; b <= n; b++) {
                for (int c = 1; c <= n ; c++) {

                    if(a * a+ b *b  == c * c){
                        res++;
                    }

                }
            }

        }



        return res;



    }

    public static int countTriples_leetcode(int n){
        int res = 0;
        // 枚举 a 与 b
        for (int a = 1; a <= n; ++a){
            for (int b = 1; b <= n; ++b){
                // 判断是否符合要求
                int c = (int)(Math.sqrt(a * a + b * b + 1.0));
                if (c <= n && c * c == a * a + b * b){
                    ++res;
                }
            }
        }
        return res;
    }



}
