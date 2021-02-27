import java.util.Arrays;
import java.util.PriorityQueue;


public class Solution {

    private static PriorityQueue<Double> maxDeque = new PriorityQueue<Double>((o1, o2) -> (int) (o2-o1));
    private static PriorityQueue<Double> minDeque = new PriorityQueue<Double>((o1, o2) -> (int) (o1-o2));

    public static void main(String[] args) {


//        int[] nums = {2147483647,1,2,3,4,5,6,7,2147483647};

        int[] nums = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};



//        int[] nums = {1,2,3,4,2,3,1,4,2};
//        int[] nums = {1,3,-1,-3,5,3,6,7};

        System.out.println(Arrays.toString(medianSlidingWindow_Pri(nums,3)));
    }

    public static double[] medianSlidingWindow_Pri(int[] nums, int k) {

        if(nums == null ){
            return null;
        }if(nums.length == 0 || k > nums.length){
            return new double[0];
        }else if(nums.length == k){
            Arrays.sort(nums);
            double[] res01 = new double[1];
            res01[0] = k % 2 == 0 ? (double)((double)nums[k/2-1] + (double) nums[k/2]) / 2.0 : (double)nums[k/2];
            return res01;
        }

        double[] res = new double[nums.length-k+1];
        int index = 0;
        heapInit(nums,k);
        res[index++] = k % 2 == 0 ? (double) ((double)maxDeque.peek() + (double)minDeque.peek()) /2.0f : (double)minDeque.peek();

        for (int i = k; i < nums.length; i++) {

            addNum(nums[i],nums[i-k]);

            // 小堆永远多1
            res[index++] = k % 2 == 0 ? ((double)maxDeque.peek() + (double)minDeque.peek()) /2.0f : (double)minDeque.peek();

        }


        return res;

    }

    public static void heapInit(int[] nums,int k){

        for (int i = 0; i < k; i++) {
            minDeque.add(nums[i]+0.0);
        }

        toBalance();

    }

    private static void addNum(int addNum,int removeNum){

        if(minDeque.contains(removeNum+0.0)){
            minDeque.remove(removeNum+0.0);
        }else{
            maxDeque.remove(removeNum+0.0);
        }
        toBalance();

        if(minDeque.size() > 0 && addNum < minDeque.peek()){
            maxDeque.add( addNum+0.0);
        }else{
            minDeque.add(addNum+0.0);
        }

        toBalance();
    }

    private static void toBalance(){

//        for (Integer integer : maxDeque) {
//            System.out.print(integer+" ");
//        }
//        System.out.print("   ");
//        for (Integer integer : minDeque) {
//            System.out.print(integer+" ");
//        }
//
//        System.out.print("  --->  ");


        while(maxDeque.size() > minDeque.size()){
            minDeque.add(maxDeque.poll());
        }

        while(minDeque.size() > (maxDeque.size() + 1) ){
            maxDeque.add(minDeque.poll());
        }

//        for (Double integer : maxDeque) {
//            System.out.print(integer+" ");
//        }
//        System.out.print("   ");
//        for (Double integer : minDeque) {
//            System.out.print(integer+" ");
//        }
//        System.out.println();

    }







}
