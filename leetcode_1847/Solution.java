import java.util.*;

public class Solution {

    public static void main(String[] args) {



        int[][] rooms = {{7,14},{11,6},{3,1},{9,4},{14,14},{17,11},{22,13},{6,25},{12,22},{21,9}};
        int[][] queries = {{21,17},{4,6},{17,25},{15,18},{17,16},{18,16},{8,17},{6,7},{9,22},{17,18}};
        int[] res = closestRoom_leetcode(rooms,queries);

        System.out.println(Arrays.toString(res));



    }


    public static int[] closestRoom_leetcode(int[][] rooms, int[][] queries) {
        
        
        if(rooms == null || queries == null){
            return null;
        }
        
        int[][] q=new int[queries.length][3];
        for(int i=0;i<q.length;i++){
            q[i][0]=queries[i][0];
            q[i][1]=queries[i][1];
            q[i][2]=i;
        }
        Arrays.sort(q,(x,y)->y[1]-x[1]);
        Arrays.sort(rooms,(x,y)->y[1]-x[1]);

        int[] res = new int[queries.length];
        Arrays.fill(res,-1);

        TreeSet<Integer> treeSet = new TreeSet<>();

        int index = 0;


        // 相当于利用TreeSet实现线段树
        for (int i = 0; i < q.length; i++) {

            while(index < rooms.length && rooms[index][1] >= q[i][1]){
                treeSet.add(rooms[index][0]);
                index++;
            }

            // 找到某一段
            Integer a = treeSet.floor(q[i][0]);
            Integer b = treeSet.ceiling(q[i][0]);

            if(b == null && a == null){
                res[q[i][2]] = -1;
            }else if(b == null || a == null ){

                res[q[i][2]] = (a == null) ? b : a;

            }else {
                res[q[i][2]] = ((q[i][0]-a)<=(b-q[i][0]))?a:b;
            }

        }
        
        
        
        
        
        
        
        return res;
        
        
        
        
    }


    // 这个应该算是暴力了
    public static int[] closestRoom_leetcode01(int[][] rooms, int[][] queries) {
        if(rooms == null || queries == null){
            return null;
        }

        Arrays.sort(rooms,(x,y) -> y[1] - x[1]);

        int[] ans = new int[queries.length];

        int len = queries.length;
        for (int i = 0; i < len; i++) {


            int min = Integer.MAX_VALUE , minIndex = -1;

            for (int j = 0; j < rooms.length; j++) {

                if(rooms[j][1] >= queries[i][1]){

                    int abs = Math.abs(rooms[j][0] - queries[i][0]);
                    if(min == abs){
                        minIndex = Math.min(minIndex , rooms[j][0]);
                    }else if(min > abs){
                        min = abs;
                        minIndex = rooms[j][0];
                    }

                }else{
                    break;
                }


            }

            ans[i] = minIndex;




        }

        return ans;

    }

    public static int[] closestRoom_mine(int[][] rooms, int[][] queries) {

        if(rooms == null || queries == null){
            return null;
        }

        LinkedList<int[]> linkedList = new LinkedList<>();

        for (int[] room : rooms) {
            linkedList.add(room);
        }

        int[] res = new int[queries.length];



        Collections.sort(linkedList, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {

                int[] s1 = (int[]) o1;
                int[] s2 = (int[]) o2;

                if (s1[1] > s2[1]) {
                    return 1;
                }else if(s1[1] < s2[1]){
                    return -1;
                }else{
                    return s1[0] - s2[0];
                }

            }
        });


        int maxSize = linkedList.size();

        int leftIndex = 0, rightIndex = maxSize;


        for (int[] ints : linkedList) {
            System.out.println(ints[0]+" "+ints[1]);
        }

        for (int i = 0; i < queries.length; i++) {

            leftIndex = 0;
            rightIndex = maxSize-1;

            int minSize = queries[i][1];
            int preferred = queries[i][0];

            while (leftIndex <= rightIndex){

                int mid = (leftIndex+rightIndex) / 2;
                if(linkedList.get(mid)[1] == minSize){
                    leftIndex = mid;
                    while(leftIndex > 0 && leftIndex < maxSize && linkedList.get(leftIndex-1)[1] == minSize){
                        leftIndex--;
                    }

                    break;
                }else if(linkedList.get(mid)[1] < minSize){
                    leftIndex = mid+1;
                }else{
                    rightIndex = mid - 1;
                }
            }

            if(leftIndex >= maxSize){
                res[i] = -1;
                continue;
            }

            int resNum = linkedList.get(leftIndex)[0];

            int minCha = Math.abs(resNum - preferred);

            for (int j = leftIndex + 1; j < maxSize; j++) {

                if(minCha > Math.abs(linkedList.get(j)[0] - preferred)){
                    resNum = linkedList.get(j)[0];
                    minCha = Math.abs(linkedList.get(j)[0] - preferred);
                }else if(minCha == Math.abs(linkedList.get(j)[0] - preferred)){
                    System.out.println(leftIndex+" "+"Min"+j+" "+resNum);
                    resNum = Math.min(linkedList.get(j)[0],resNum);
                }

            }

            res[i] = resNum;


        }



        return res;





    }
}
