

import java.util.Arrays;

//  5718. 统计一个圆中点的数目
public class Solution {

    public static void main(String[] args) {

        int[][] points = {{1,1},{2,2},{3,3},{4,4},{5,5}}, queries = {{1,2,2},{2,2,2},{4,3,2},{4,3,3}};

        int[] res = countPoints(points,queries);
        System.out.println(Arrays.toString(res));


    }


    public static int[] countPoints(int[][] points, int[][] queries) {

        if(points == null || queries == null){
            return null;
        }

        int cntCircle = queries.length;
        int pointTotal = points.length;
        
        int[] res = new int[queries.length];


        for (int i = 0; i < cntCircle; i++) {

            for (int j = 0; j < pointTotal; j++) {

                res[i] += isInCircle(queries[i] , points[j]) == true ? 1 :  0;

            }


        }
        
        
        return res;
        
        
        

    }

    private static boolean isInCircle(int[] circle  ,int[] point){

        double distance = Math.sqrt( Math.pow((double) Math.abs(circle[0] - point[0]) ,2 ) + Math.pow((double) Math.abs(circle[1] - point[1]) , 2) );

        return distance <= circle[2] ;

    }

}
