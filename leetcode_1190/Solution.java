
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

//        s = "a(bcdefghijkl(mno)p)q"
//输出："apmnolkjihgfedcbq"

        String s = "(ed(et(oc))el)";
//        apmnolkjihgfedcbq
        System.out.println(reverseParentheses(s));


    }

    public static String reverseParentheses(String s) {

        if(s == null){
            return null;
        }

        char[] strs = s.toCharArray();
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        StringBuffer stringBuffer = new StringBuffer();

        int curIndex = 0;

        while(curIndex < len){

            stack.push(strs[curIndex]);
            if(stack.peek() == ')'){
                stack.pop();
                while(!stack.isEmpty() && stack.peek() != '('){
                    stringBuffer.append(stack.pop());
                }
                stack.pop();

//                for (int i = stringBuffer.length()-1; i >= 0; i--) {
//                    stack.push(stringBuffer.charAt(i)) ;
//                }

                for (int i = 0; i < stringBuffer.length(); i++) {
                    stack.push(stringBuffer.charAt(i)) ;
                }

                stringBuffer = new StringBuffer();

            }
            curIndex++;

        }

        stringBuffer = new StringBuffer();

        while(!stack.isEmpty()){
            stringBuffer.append(stack.pop());
        }

        return stringBuffer.reverse().toString();

    }


}
