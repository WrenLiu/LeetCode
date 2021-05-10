

import java.math.BigInteger;
import java.util.ArrayList;

public class Solution {

    private static boolean res ;
    public static void main(String[] args) {

        String s = "050043";
//        System.out.println(splitString(s));
        BigInteger val = new BigInteger("-1");

        BigInteger string = new BigInteger("47714");
        BigInteger str01 = new BigInteger("47713");
        System.out.println(string.add(val).equals(str01));

    }

    public static boolean splitString(String s) {

        if(s == null){
            return false;
        }

        res = false;
        int curIndex = 1;

        ArrayList<BigInteger> arr = new ArrayList<>();
        dfs(s , 0 , arr );

        return res;


    }

    private static void dfs(String s ,int startIndex,   ArrayList<BigInteger> arrayList){

        BigInteger val = new BigInteger("-1");
        if(startIndex == s.length() && arrayList.size() > 1 && isOk(arrayList)){

//            for (Integer integer : arrayList) {
//                System.out.print(integer+" ");
//            }
//            System.out.println();
            res = true;
            return ;
        }


        for (int i = startIndex+1; i <= s.length(); i++) {

//            BigInteger num = Long.parseLong(s.substring(startIndex , i));
            BigInteger num = new BigInteger(s.substring(startIndex,i));

            if(arrayList.size() == 0){

                arrayList.add(num);
                dfs(s,i ,  arrayList);
                arrayList.remove(arrayList.size()-1);

            }else if(arrayList.get(arrayList.size()-1).add(val).equals(num)){
                System.out.println("------");
                arrayList.add(num);
                dfs(s , i, arrayList);
                arrayList.remove(arrayList.size()-1);

            }



        }

    }

    private static boolean isOk(ArrayList<BigInteger> arr){
        BigInteger pivot = arr.get(0);
        BigInteger val = new BigInteger("-1");
        for (int i = 1; i < arr.size(); i++) {
            if(! pivot.add(val).equals( arr.get(i))){
                return false;
            }

            pivot = arr.get(i);

        }

        return true;
    }

}
