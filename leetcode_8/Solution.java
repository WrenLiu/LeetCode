class Solution {

    // 全局变量判断是真的0还是是违法输入
private static boolean ErrorisFalse_0isTrue = true;
public int myAtoi(String str) {
    if(str == null ){
        ErrorisFalse_0isTrue = false;
        return 0;
    }

    if(str.length() == 0){
        return 0;
    }

    char[] chars = str.toCharArray();
    int indexChars = 0;


    while(indexChars < str.length() && chars[indexChars] == ' '){
        indexChars++;
    }

    int sign = 1;

    if(indexChars < str.length() && chars[indexChars] == '+'){
        indexChars++;
    }else if(indexChars < str.length() && chars[indexChars] == '-'){
        indexChars++;
        sign = -1;
    }

    long result = 0;

    while(indexChars != str.length()){

        if(chars[indexChars] >= '0' && chars[indexChars]<= '9'){

            result = result*10 + sign * (chars[indexChars] - '0');

            // 边界条件的判断
            if( (sign == -1 && result < Integer.MIN_VALUE) || (sign == 1 && result > Integer.MAX_VALUE)){

                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            indexChars++;


        }else{

            break;
        }


    }

    return (int)result;



}
}