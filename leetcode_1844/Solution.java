

public class Solution {

    // 5730
    public static void main(String[] args) {

        System.out.println(replaceDigits("a1b2c3d4e"));


    }
    public static String replaceDigits(String s) {

        if(s == null || s.length() == 0){
            return s;
        }

        StringBuffer res = new StringBuffer(s);
        char ch ;
        for (int i = 0; i < res.length(); i++) {

            if(i+1 < res.length()){
                ch = (char) (res.charAt(i) + res.charAt(i+1) - '0');
            }else{
                break;
            }
            res.replace(i+1,i+2,ch+"");
            i++;



        }

        return res.toString();

    }
}
