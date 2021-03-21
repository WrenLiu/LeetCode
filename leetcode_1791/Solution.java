

import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {

        int[][] edges = {{1,2},{5,1},{1,3},{1,4}};

        System.out.println(findCenter(edges));

    }

    public static int findCenter_leetcode(int[][] edges) {

        if(edges[0][0]==edges[1][0])
        {
            return edges[0][0];
        }
        if(edges[0][0]==edges[1][1])
        {
            return edges[0][0];
        }

        return edges[0][1];
    }

    public static int findCenter(int[][] edges) {

        if(edges == null || edges.length == 0){
            return -1;
        }

        HashSet<Integer> set = new HashSet<>();

        set.add(edges[0][0]);
        set.add(edges[0][1]);
        if(set.contains(edges[1][0])){
            return edges[1][0];
        }else if(set.contains(edges[1][1])){
            return edges[1][1];
        }

        return -1;



    }


}
