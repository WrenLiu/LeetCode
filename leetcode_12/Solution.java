
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {

        String res = intToRoman(1994);
        System.out.println(res);
    }

    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman_leetcode(int num) {
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }


    public static String intToRoman(int num) {

        if(num <= 0){
            return null;
        }

        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(1,"I");
        treeMap.put(5,"V");
        treeMap.put(4,"IV");
        treeMap.put(9,"IX");
        treeMap.put(10,"X");
        treeMap.put(40,"XL");
        treeMap.put(50,"L");
        treeMap.put(90,"XC");
        treeMap.put(100,"C");
        treeMap.put(400,"CD");
        treeMap.put(500,"D");
        treeMap.put(900,"CM");
        treeMap.put(1000,"M");

        StringBuffer res = new StringBuffer("");

        while(num > 0){
            int tmp = treeMap.floorKey(num);
            res.append(treeMap.get(tmp));
            num -= tmp;

        }


        return res.toString();

    }


}
