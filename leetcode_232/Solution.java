
import java.util.Stack;

public class Solution{

    static class MyQueue {

        private Stack<Integer> stackIn;
        private Stack<Integer> stackOut;

        /** Initialize your data structure here. */
        public MyQueue() {
            stackIn = new Stack<>();
            stackOut = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stackIn.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {

            int tmp ;

            while(!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
            tmp = stackOut.pop();
            while(!stackOut.isEmpty()){
                stackIn.push(stackOut.pop());
            }

            return tmp ;


        }

        /** Get the front element. */
        public int peek() {
            int  tmp ;

            while(!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
            tmp = stackOut.peek();
            while(!stackOut.isEmpty()){
                stackIn.push(stackOut.pop());
            }

            return tmp;


        }

        /** Returns whether the queue is empty. */
        public boolean empty() {

            return stackIn.isEmpty() && stackOut.isEmpty();

        }
    }



    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        myQueue.push(5);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());


    }




}
