
public class Solution {


    public static void main(String[] args) {
        String firstWord = "acb", secondWord = "cba", targetWord = "cdb";


        System.out.println(isSumEqual(firstWord,secondWord,targetWord));
    }

    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {

        String firstNum = "" ,secondNum = "" ,targetNum = "";

        for (int i = 0; i < firstWord.length(); i++) {
            firstNum = firstNum + (firstWord.charAt(i) - 'a' + "");
        }

        for (int i = 0; i < secondWord.length(); i++) {
            secondNum = secondNum + (secondWord.charAt(i) - 'a' + "");
        }

        for (int i = 0; i < targetWord.length(); i++) {
            targetNum = targetNum + (targetWord.charAt(i) - 'a' + "");
        }




        return Integer.parseInt(firstNum) + Integer.parseInt(secondNum) == Integer.parseInt(targetNum);


    }


}
