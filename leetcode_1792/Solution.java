
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {

        int[][] classes =  {{2,4},{3,9},{4,5},{2,10}};

        System.out.println(maxAverageRatio(classes,4));

    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {

        if(classes == null || classes.length == 0){
            return 0.0f;
        }


        double result = 0.0;
        int total = classes.length;

//        deltaX = (pass+1) / (total + 1) - pass / total;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b)->{
            double x = ((double) b[0]+1)/((double)b[1]+1) - (double) b[0]/b[1];
            double y = ((double)a[0]+1)/((double)a[1]+1) - (double) a[0]/a[1];
            if(x > y) return 1;
            if(x < y) return -1;
            return 0;
        });
        
        
        for (int i = 0; i < classes.length; i++) {
            queue.offer(classes[i]);
        }
        
        for (int i = 0; i < extraStudents; i++) {
            int[] tmp = queue.poll();

            tmp[0] ++;
            tmp[1] ++;
            queue.offer(tmp);
        }

        for (int[] ints : queue) {
            result += (double) ints[0] / ints[1];
        }

        return result / total;


    }

}
