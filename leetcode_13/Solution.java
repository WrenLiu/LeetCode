

import java.util.HashMap;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {

        String str = "MCMXCIV";
        System.out.println(romanToInt(str));
        System.out.println(romanToInt_Leetcode(str));

    }

    private static int romanToInt_Leetcode(String s){
        if(s == null){
            return 0;
        }


        int preNum = getValue(s.charAt(0));
        int res = 0;
        int curNum;
        int index = 1;

        while(index < s.length()){

            curNum = getValue(s.charAt(index));

            if(curNum > preNum){
                res -= preNum;
            }else{
                res += preNum;
            }

            preNum = curNum;
            index ++;
        }

        res += preNum;
        return res;




    }

    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static int romanToInt(String s) {


        if(s == null){
            return 0;
        }

        int res = 0;

        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("I",1);
        hashMap.put("V",5);
        hashMap.put("IV",4);
        hashMap.put("IX",9);
        hashMap.put("X",10);
        hashMap.put("XL",40);
        hashMap.put("L",50);
        hashMap.put("XC",90);
        hashMap.put("C",100);
        hashMap.put("CD",400);
        hashMap.put("D",500);
        hashMap.put("CM",900);
        hashMap.put("M",1000);


        int index = s.length()-1;
        String tmp ;

        while(index >= 0){
            if(index > 0){
                tmp = s.substring(index-1,index+1);
            }else{
                tmp = s.charAt(index)+"";
            }

            if(hashMap.containsKey(tmp)){
                res += hashMap.get(tmp);
                index -= 2;
            }else{
                tmp = s.charAt(index)+"";
                res += hashMap.get(tmp) ;
                index--;
            }
        }

        return res;

    }
}
