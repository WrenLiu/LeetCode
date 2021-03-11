
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        System.out.println("res  "+calculate_leetcode(" 3/2 "));

    }

    private static int calculate_leetcode(String s){

        if(s == null || s.length() == 0){
            return -1;
        }
        int len = s.length();


        int curNum = 0;
        Stack<Integer> stack = new Stack<>();
        char pre_op = '+';

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if(ch == ' '){
                continue;
            }

            if(Character.isDigit(ch)){
                curNum = ch - '0';
                while(i+1 < len && Character.isDigit(s.charAt(i+1))){
                    curNum = curNum * 10 + s.charAt(++i) - '0';
                }


            }else{

                switch(pre_op){
                    case '+':
                        stack.push(curNum);
                        break;
                    case '-':
                        stack.push(-1 * curNum);
                        break;
                    case '*':
                        stack.push(stack.pop() * curNum);
                        break;
                    case '/':
                        stack.push(stack.pop() / curNum);
                        break;
                    default :
                        break;

                }


                pre_op = ch;


            }

        }

        
        // 最后还有一个数，处理的不是很干净
        switch(pre_op){
            case '+':
                stack.push(curNum);
                break;
            case '-':
                stack.push(-1 * curNum);
                break;
            case '*':
                stack.push(stack.pop() * curNum);
                break;
            case '/':
                stack.push(stack.pop() / curNum);
                break;
            default :
                break;

        }



        System.out.print("Stack:  ");
        for (Integer integer : stack) {
            System.out.print(integer+" ");
        }
        System.out.println();


        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }



        return ans;






    }

    public static int calculate(String s) {

        if(s == null || s.length() == 0){
            return -1;
        }


        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                continue;
            }
            stringBuffer.append(s.charAt(i));
        }

        int sign = 1;
        int curNum = 0;


        boolean isMultiplication ;
        while((stringBuffer.indexOf("*") != -1 ) || (stringBuffer.indexOf("/") != -1)) {

            int index = 0;
            if(stringBuffer.indexOf("*") == -1){
                isMultiplication = false;
                index = stringBuffer.indexOf("/");
            }else if(stringBuffer.indexOf("/") == -1){
                isMultiplication = true;
                index = stringBuffer.indexOf("*");

            }else if((stringBuffer.indexOf("*") > stringBuffer.indexOf("/"))){
                isMultiplication = false;
                index = stringBuffer.indexOf("/");
            }else{
                isMultiplication = true;
                index = stringBuffer.indexOf("*");
            }

            int leftNum = 0;
            int rightNum = 0;


            int leftIndex = index-1;
            leftNum = stringBuffer.charAt(leftIndex) - '0';
            System.out.println(leftNum);
            int jishu = 1;

            while (leftIndex-1 >= 0 && Character.isDigit(stringBuffer.charAt(leftIndex-1))){

                leftNum = (int) (leftNum + Math.pow(10,jishu++) * (stringBuffer.charAt(--leftIndex) - '0'));
            }

            int rightIndex = index +1 ;
            rightNum = stringBuffer.charAt(rightIndex) - '0';

            while (rightIndex+1 < stringBuffer.length() && Character.isDigit(stringBuffer.charAt(rightIndex+1))){
                rightNum = rightNum * 10 + stringBuffer.charAt(++rightIndex) - '0';
            }


            int res;
            if(isMultiplication){
                res = leftNum * rightNum;
            }else{
                res = leftNum / rightNum;
            }
            stringBuffer.replace(leftIndex,rightIndex+1,res+"");
            System.out.println(stringBuffer);



        }


        int res = 0;

//        if(s.charAt(0) == '-'){
//            sign = -1;
//        }else {
//            sign = 1;
//        }

        System.out.println(stringBuffer);
        for (int i = 0; i < stringBuffer.length();i++) {

            char ch = stringBuffer.charAt(i);

            if(Character.isDigit(ch)){
                curNum = ch - '0';
                while(i+1 < stringBuffer.length() && Character.isDigit(stringBuffer.charAt(i+1))){
                    curNum = curNum * 10 + stringBuffer.charAt(++i) - '0';
                }


            }else if(ch == '+'){

                res += sign * curNum;
                sign = 1;


            }else if(ch == '-'){
                res += sign * curNum;
                sign = -1;

            }

        }

        res += curNum * sign;





        return res;

    }


}
