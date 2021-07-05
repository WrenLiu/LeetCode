


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {

    static int len ;
    static String formula;
    static int index;
    public static void main(String[] args) {

        String str = "H2O";
        System.out.println(countOfAtoms(str));
    }



    public static String countOfAtoms(String _formula) {

        if(_formula == null){
            return null;
        }


        formula = _formula;
        len = formula.length();

        Stack<HashMap<String ,Integer>> stack = new Stack<>();

        index = 0;

        stack.push(new HashMap<String , Integer>());

        while(index < len){

            char ch = formula.charAt(index);

            if(ch == '('){
                index++;
                stack.push(new HashMap<String ,Integer>()); // 放进去一个空的Hash表
            }else if(ch == ')'){
                index++;
                int num = parseNum(); // 获得数字
                HashMap<String , Integer> popMap = stack.pop();
                HashMap<String , Integer> topMap = stack.peek();

                for(Map.Entry<String , Integer> entry : popMap.entrySet()){
                    String element = entry.getKey();
                    int v = entry.getValue();
                    topMap.put(element , topMap.getOrDefault(element , 0 ) +v * num);
                }


            }else{

                String element = parseAtom();
                int num = parseNum();
                HashMap<String , Integer> topMap = stack.peek();
                topMap.put(element , topMap.getOrDefault(element , 0)+num);


            }

        }

        HashMap<String  , Integer> map = stack.pop();

        TreeMap<String ,Integer> treeMap = new TreeMap<>(map);

        StringBuffer res = new StringBuffer();

        for (String string : treeMap.keySet()) {
            res.append(string);

            int count=  treeMap.get(string);
            if(count > 1) {
                res.append(count);
            }
        }



        return res.toString();


    }

    public static String parseAtom(){

        StringBuffer res = new StringBuffer();

        res.append(formula.charAt(index++));
        while(index < len && Character.isLowerCase(formula.charAt(index))){
            res.append(formula.charAt(index++));
        }

        return res.toString();



    }


    public static int parseNum(){

        if(index == len || !Character.isDigit(formula.charAt(index))){
            return 1; // 不是数字,这个数字是日后预增的倍数
        }

        int res = 0;

        while(index < len && Character.isDigit(formula.charAt(index))){
            res = res * 10 + (formula.charAt(index++) - '0') ; // 扫描数字
        }

        return res ;
    }
}
