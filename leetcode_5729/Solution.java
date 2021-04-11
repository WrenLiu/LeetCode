
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Solution{


    public static void main(String[] args) {


        MKAverage obj = new MKAverage(3, 1);
        obj.addElement(3);
        obj.addElement(1);
        int tmp01 = obj.calculateMKAverage();

        System.out.println(tmp01); // -1

        obj.addElement(10);
        tmp01 = obj.calculateMKAverage();

        System.out.println(tmp01);  // 3


        obj.addElement(5);
        obj.addElement(5);
        obj.addElement(5);        // 当前元素为 [3,1,10,5,5,5]
        tmp01 = obj.calculateMKAverage(); // 最后 3 个元素为 [5,5,5]

        System.out.println(tmp01);  // 5
        // 删除最小以及最大的 1 个元素后，容器为 [5]
        // [5] 的平均值等于 5/1 = 5 ，故返回 5

    }


    static class MKAverage {

        private static int m , k;

        ArrayList<Integer> arrayList = new ArrayList<>();
//        int[] arr = new int[m];

        public MKAverage(int m, int k) {

            this.m = m;
            this.k = k;

        }

        public void addElement(int num) {

            arrayList.add(num);

        }

        public int calculateMKAverage() {

            if(arrayList.size() < m){
                return -1;
            }
            int[] arr=  new int[m];


            for (int i = 0; i < m; i++) {

                arr[i] = arrayList.get(arrayList.size()-i-1);

            }


            Arrays.sort(arr);

            long sum = 0;
            for (int i = k; i < m-k; i++) {
                sum += arr[i];
            }


            return (int) (sum / (m-2*k));




        }
    }




}
