

import java.util.Stack;

public class Solution{

    public static void main(String[] args) {

        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));


    }

    public static int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }

        Stack<Integer> stackNum = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            if(Character.isDigit(tokens[i].charAt(0)) || tokens[i].length() > 1){
                stackNum.push(Integer.decode(tokens[i]));

                continue;
            }

            char ch = tokens[i].charAt(0);

            int num1 = stackNum.pop();
            int num2 = stackNum.pop();
            int res = 0;

            switch (ch){
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num2 - num1;
                    break;
                case '/':
                    res = num2 / num1;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                default:
                    break;
            }

            stackNum.push(res);

        }





        return stackNum.peek();
    }


}
