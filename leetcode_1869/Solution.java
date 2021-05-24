
public class Solution {

    public static void main(String[] args) {

        String str = "1101";
        System.out.println(checkZeroOnes(str));


    }

    public static boolean checkZeroOnes(String s) {

        if(s == null){
            return false;
        }

        int max0Len = 0 , max1Len = 0;

        int leftIndex = 0 , rightIndex = 0;
        while(rightIndex < s.length()){

            if(s.charAt(rightIndex) == s.charAt(leftIndex)){
                while(rightIndex < s.length() && s.charAt(rightIndex) == s.charAt(leftIndex)){
                    rightIndex++;
                }
            }

            if(s.charAt(leftIndex) == '0'){
                max0Len = Math.max(max0Len, rightIndex - leftIndex);
            }else{
                max1Len = Math.max(max1Len , rightIndex - leftIndex);
            }

            leftIndex = rightIndex;

        }

        return max1Len > max0Len;








    }


}
