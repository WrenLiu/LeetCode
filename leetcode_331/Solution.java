import java.util.Stack;

public class Solution {


    public static void main(String[] args) {


        System.out.println(isValidSerialization_Stack("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(isValidSerialization("#,7,6,9,#,#,#"));
    }

    public static boolean isValidSerialization(String preorder){

        if (preorder == null || preorder.length() == 0) {
            return false;
        }


        String[] strings = preorder.split(",");

        int diff = 1;


        for (int i = 0; i < strings.length; i++) {

            diff -= 1;
            if(diff < 0) {
                return false;
            }

            if(!strings[i].equals("#")){

                diff += 2;
            }



        }


        return diff == 0;

    }


    // 当遇到 ` x # # ` 的时候，就把它变为 `#`
    public static boolean isValidSerialization_Stack(String preorder) {

        if (preorder == null || preorder.length() == 0) {
            return false;
        }


        String[] strings = preorder.split(",");

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strings.length; i++) {

            stack.push(strings[i]);

            while(stack.size() >= 3 && stack.peek().equals("#") && stack.get(stack.size()-2).equals("#") && !stack.get(stack.size()-3).equals("#")){
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
            }


        }
//
        System.out.println("-----");

        for (String string : stack) {
            System.out.println(string);
        }
        System.out.println("-----");

        if(stack.size() == 1 && stack.peek().equals("#")){
            return true;
        }else{
            return false;
        }






    }




}
