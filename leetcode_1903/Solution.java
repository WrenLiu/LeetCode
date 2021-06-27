
public class Solution {

    public static void main(String[] args) {


        System.out.println(largestOddNumber("4206"));

    }
    public static String largestOddNumber(String num) {

        if(num == null){
            return null;
        }

        int index = num.length()-1;

        while(index >= 0 && (num.charAt(index) - '0' ) % 2 != 1){
            index --;
        }

        if(index < 0){
            return "";
        }

        return num.substring(0,index+1);

    }

}
