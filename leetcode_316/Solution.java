

import java.util.HashMap;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        String s = removeDuplicateLetters("bcabc");
        System.out.println(s);

    }
    public static String removeDuplicateLetters(String s) {

        if(s == null || s.length() == 0){
            return null;
        }

        Stack<Character> stack = new Stack<>();
        StringBuffer res = new StringBuffer();

        // 思路就是 遇到一个新字符 如果比栈顶小 并且在新字符后面还有和栈顶一样的 就把栈顶的字符抛弃了
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if(stack.contains(ch)){
                continue;
            }



            while(!stack.isEmpty() && stack.peek() > ch && s.indexOf(stack.peek(), i) != -1 ){
                stack.pop();
            }

            stack.push(ch);



        }



        while(!stack.isEmpty()){
            res.insert(0,stack.pop());
        }

        return res.toString();


    }



}
