
import java.util.*;


public class Solution {

    public static void main(String[] args) {

//        {{1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}}
        List<List<Integer>> wall = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        list.add(1);list.add(2);list.add(2);list.add(1);
        wall.add(list);

        System.out.println(leastBricks(wall));


    }

    public static int leastBricks(List<List<Integer>> wall) {

        if(wall == null || wall.get(0) == null){
            return 0;
        }

        int height = wall.size();

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (List<Integer> list : wall) {
            int len = 0;
            for (int i = 0; i < list.size()-1; i++) {
                len += list.get(i);
                hashMap.put(len , hashMap.getOrDefault(len,0)+1);
            }
        }


        int max = 0;

        for (Integer integer : hashMap.keySet()) {
            max = Math.max(max,hashMap.get(integer));
        }

        return height - max;

    }


}
