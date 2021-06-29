

public class Solution {

    public static void main(String[] args) {

        String str = "A";
        System.out.println(titleToNumber(str));
    }

    public static int titleToNumber(String columnTitle) {

        if(columnTitle == null || columnTitle.length() == 0){
            return 0;
        }

        int res = 0;
        int n = 0;
        int len = columnTitle.length();

        int strIndex = columnTitle.length()-1;

        while(strIndex >= 0){
            char ch = columnTitle.charAt(strIndex--);
            res += (ch - 'A' + 1) * (int)Math.pow(26 , n++);
        }

        return res;
    }


}
