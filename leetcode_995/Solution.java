


import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {


        // 滑动窗口是可行的，即只要遇到窗口的第一个数是0就全部翻转，最后判断全部数组中有无0

        // A[i] 翻转偶数次的结果是 A[i]A[i]；翻转奇数次的结果是 A[i]^1，即位置 i 现在的状态，和它被前面K−1个元素翻转的次数（奇偶性）有关。
        int[] nums = {0,0,0,1,0,1,1,0};
        System.out.println(minKBitFlips(nums,3));

    }

    public static int minKBitFlips(int[] nums, int K) {

        if(nums == null || K <= 0 || nums.length < K ){
            return -1;
        }
        
        int count = 0;
        // 存储的是元素的位置
        Deque<Integer> deque = new LinkedList<>();

       for (int i = 0; i < nums.length; i++) {
            // 说明当前的第i个元素已经不在原来由deque.peek()打头的这个子数组中了，那么我们就需要清除deque最前面的数组
            if(deque.size() > 0 && i > deque.peek()+K-1){
                deque.removeFirst();
            }

            // deque.size() % 2代表翻转后的状态，奇数代表变化，偶数代表没有变化
            if(deque.size() % 2== nums[i]){
                if(i + K > nums.length){
                    // 当最后一个子数组依然有0的时候就返回-1
                    return -1;
                }

                deque.add(i);
                count++;
            }


        }




        return count;



    }



}
