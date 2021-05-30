
import java.util.ArrayList;


public class Solution {

    public static void main(String[] args) {
        String n = "-132";
        int x = 3;
////        -1323


//        String n = "-13";
//        int x = 2;
//        -123

//        String n = "-648468153646";
//        int x = 5;

//        "-5648468153646"
//         -6484681536456
        System.out.println(maxValue(n,x));
    }

    public static String maxValue(String n, int x) {

        if(n == null || n.length() == 0){
            return n;
        }
        String res ;

        if(n.charAt(0) == '-'){
            res = "-" + findMin(n.substring(1,n.length()) , x);
        }else{
            res = findMax(n.substring(0,n.length()) , x);

        }


        return res;

    }

    private static String findMin(String str , int x){

        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if(stringBuffer.charAt(i) - '0' > x){
                stringBuffer.insert(i,(char) (x+'0'));
                return stringBuffer.toString();
            }


        }


        return stringBuffer.append( (char)(x+'0')).toString();
    }
    private static String findMax(String str , int x){

        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if(stringBuffer.charAt(i) - '0' < x){
                stringBuffer.insert(i,(char) (x+'0'));
                return stringBuffer.toString();
            }


        }

        return stringBuffer.append((char)(x+'0')).toString();

    }



}
