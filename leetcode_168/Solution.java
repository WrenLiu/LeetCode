

public class Solution {

    public static void main(String[] args) {

        int columnNumber = 2147483647;

//        System.out.println(convertToTitle(columnNumber));
        convertToTitle(columnNumber);

    }
    public static String convertToTitle(int columnNumber) {

        if(columnNumber < 1){
            return "";
        }

        String res = "";

        int n = 1;
//        res = (char)('A'+posNum -1) + res ;
        int yushu = 0;

        while (columnNumber > 0){

            int num = columnNumber % (int) Math.pow(26 , n);

            if(num == 0){
                num = 26 * (int)Math.pow(26,n-1);
            }

            int posNum = num / (int)Math.pow(26,n-1);

            columnNumber -= num;

            res = (char)('A'+posNum -1) + res ;

            n++;
        }


//        System.out.println(res);
        return res;





    }

    private static String convertToTitle_leetcode(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n =n / 26;
        }
        return sb.reverse().toString();
    }

}
