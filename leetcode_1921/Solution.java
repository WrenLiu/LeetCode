
import java.util.Arrays;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {

        int[] dist = {1,3,4}, speed = {1,1,1};

        System.out.println("res "+eliminateMaximum(dist , speed));

    }


    public static int eliminateMaximum_leetcode(int[] dist, int[] speed) {

        int len = dist.length;
        int[] div = new int[len];
        for (int i = 0; i < len; i++) {
            div[i] = (int) Math.ceil((float) dist[i] / speed[i]);
        }
        Arrays.sort(div);

        int index = 0;
        int count = 0;
        int round = 1;
        while (index < len) {
            if (round++ <= div[index++]) count++;
            else return count;
        }
        return count;
    }


    public static int eliminateMaximum(int[] dist, int[] speed) {

        if(dist == null || speed == null){
            return 0;
        }

        int res = 0;

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        int count = dist.length;

        for (int i = 0; i < count; i++) {

            if(dist[i] == 0){
                treeMap.put(0, treeMap.getOrDefault(0  ,0)+1);
                return 0;
            }

            if(dist[i] % speed[i] != 0){
                int yushu = dist[i] / speed[i];
                treeMap.put(yushu   , treeMap.getOrDefault(yushu , 0)+1 );
            }else {
                treeMap.put(dist[i]  / speed[i] - 1, treeMap.getOrDefault(dist[i] / speed[i]-1 , 0)+1);
            }

        }

        int curTime = 0;

        int maxTime = treeMap.lastKey();

//        for (Integer integer : treeMap.keySet()) {
//            System.out.println(integer+" "+treeMap.get(integer));
//        }
//        System.out.println("________________________________");

        while(!treeMap.isEmpty() && curTime <= maxTime){


            if(treeMap.containsKey(curTime)){

                treeMap.put(curTime , treeMap.get(curTime)-1);
//                System.out.println("cur"+curTime);

                res++;

                if(treeMap.get(curTime) != 0){
                    return res;
                }else {
                    treeMap.remove(curTime);
                }

                curTime++;
                continue;
            }else {

                int nextTime = treeMap.ceilingKey(curTime);
//                System.out.println("next "+nextTime);

                treeMap.put(nextTime , treeMap.get(nextTime)-1);
                res++;

                if(treeMap.get(nextTime) == 0){
                    treeMap.remove(nextTime);
                }
                curTime++;




            }

        }




        return res;




    }



}
