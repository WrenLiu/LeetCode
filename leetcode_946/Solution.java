

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};
//        int[] popped = {4,3,5,1,2};

        System.out.println(validateStackSequences(pushed,popped));

    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        if(pushed==null || popped==null || pushed.length != popped.length){
            return false;
        }

        Stack<Integer> pushStack = new Stack<>();

        int indexPush = 0;
        int indexPop = 0;

        while(indexPush != pushed.length  ){

            if(indexPush < pushed.length){
                pushStack.push(pushed[indexPush++]);
            }

            if(popped[indexPop] == pushStack.peek()){
                while(indexPop < popped.length && !pushStack.isEmpty() && popped[indexPop] == pushStack.peek()){
                    pushStack.pop();
                    indexPop++;
                }
            }

        }

        return indexPop == popped.length;


    }

    public static boolean validateStackSequences_LeetCode (int[] pushed, int[] popped) {
        int index =0 ;

        Stack<Integer> pushStack = new Stack<>();

        for(int elem : pushed) {

            pushStack.push(elem);

            while(index < popped.length && !pushStack.isEmpty() && popped[index] == pushStack.peek() ){
                pushStack.pop();
                index++;
            }
        }

        return index == popped.length;
    }


}
