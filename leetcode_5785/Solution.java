
import java.util.ArrayList;

public class Solution{


    public static void main(String[] args) {

        int[][] triplets = {{2,5,3},{1,8,4},{1,7,5}};
        int[] target = {2,7,5};

        System.out.println(mergeTriplets(triplets , target));

    }

    public static boolean mergeTriplets(int[][] triplets, int[] target) {

        if(triplets == null || target == null){
            return false;
        }

//        ArrayList<int[]> arrayList = new ArrayList<>();
        int t1 = 0,t2 = 0,t3 = 0;
        for (int i = 0; i < triplets.length; i++) {
            if(triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2]){
                continue;
            }else{
                t1 = Math.max(t1,  triplets[i][0]);
                t2 = Math.max(t2 , triplets[i][1]);
                t3 = Math.max(t3  , triplets[i][2]);
//                arrayList.add(triplets[i]);
            }
        }

        if(t1 == target[0] && t2 == target[1] && t3 == target[2]){
            return true;
        }



        return false;



    }


}
