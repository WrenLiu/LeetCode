

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {


        System.out.println(calculate_Stack("1-(2+3-(4+(5-(1-(2+4-(5+6))))))"));

//        System.out.println(myCal("-2+1"));

    }

    public static int calculate_Stack(String s){

        if(s == null || s.length() == 0){
            return -1;
        }
        
        int res = 0;
        
        int num =0;
        
        // 符号，加号+1，减号-1
        int sign = 1;
        
        Stack<Integer> stack = new Stack<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {

            if(s.charAt(i) == ' '){
                continue;
            }

            char c = s.charAt(i);
            if(Character.isDigit(c)){

                int curNum = c - '0';

                // 发现某一位是数字后，找到这个整个的数字
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    curNum = curNum*10 + s.charAt(++i) - '0';
                }

                res += sign * curNum;

                //
            }else if(c == '+'){
                sign = 1;
            }else if(c == '-'){
                sign = -1;
            }else if(c == '('){

                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;

            }else if(c == ')'){
                res = stack.pop() * res + stack.pop();
            }

        }

        return res;
        
        

    }

    public static int calculate(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }

        int len = s.length();

        StringBuffer stringBuffer = new StringBuffer();


        for (int i = 0; i < len; i++) {
            if(s.charAt(i) == ' '){
                continue;
            }
            stringBuffer.append(s.charAt(i));
        }

        while(stringBuffer.indexOf("(") != -1){

            int left = stringBuffer.lastIndexOf("(");
            int right = stringBuffer.substring(left,stringBuffer.length()).indexOf(")")+left;

            int num = myCal(stringBuffer.substring(left+1,right));

            stringBuffer.replace(left,right+1,num+"");


            System.out.println("New :  "+stringBuffer);


        }

        return myCal(stringBuffer.toString());




    }

    private static int myCal(String string){

        System.out.println("Need  "+string);

        int sum = 0;
        StringBuffer numString = new StringBuffer();

        for (int i = string.length()-1; i >= 0; i-- ) {


            if (string.charAt(i) == '+') {
                sum += Integer.decode(numString.toString());

                numString = new StringBuffer();

            } else if (string.charAt(i) == '-' && i-1 >= 0 &&string.charAt(i - 1) == '-') {

                sum += Integer.decode(numString.toString());
                numString = new StringBuffer();
                i--;

            } else if (string.charAt(i) == '-' && i-1 >= 0 &&string.charAt(i - 1) == '+') {
                sum -= Integer.decode(numString.toString());
                numString = new StringBuffer();
                i--;

            }else if(( string.charAt(i) == '-' && i-1 >= 0 && string.charAt(i-1) != '-' )||(string.charAt(i) == '-' && i == 0) ){

                sum -= Integer.decode(numString.toString());
                numString = new StringBuffer();


            }else{
                numString.insert(0,string.charAt(i));
            }


        }
        if(string.charAt(0) == '-'){
            return sum;
        }
        sum += Integer.decode(numString.toString());

        return sum;


    }

}
