

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution {

    static class MedianFinder {

        PriorityQueue<Integer> bigHeap ; // 大堆，保存小数
        PriorityQueue<Integer> smallHeap;// 小堆，保存大数

        public MedianFinder() {
            bigHeap = new PriorityQueue<>((n1,n2)->n2-n1); // 大堆
            smallHeap = new PriorityQueue<>(); // 小堆
        }

        public void addNum(int num) {

            bigHeap.add(num);
            smallHeap.add(bigHeap.poll());

//            System.out.print(bigHeap.size()+" "+smallHeap.size()+"   ");

            // 最开始添加数据都是往小堆走，所以很容易小堆比大堆多一些，
            // 为了保持两个堆的大小一致或者差在1以内（大堆日后还要先加新的数据），就需要从小堆往大堆里添加数据
            if(smallHeap.size() > bigHeap.size()+1){
                bigHeap.add(smallHeap.poll());
            }
//            System.out.print(bigHeap.size()+" "+smallHeap.size()+"   ");

        }

        public double findMedian() {


            if(bigHeap.size() == smallHeap.size()){
                return (double) (smallHeap.peek() + bigHeap.peek() )/2.0;
            }

            return smallHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        double result = 0.0;
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());


        medianFinder.addNum(-3);
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());



        System.out.println("Hello World");

    }



}
