
public class Solution {

    public static void main(String[] args) {
        int[] rungs = {3};
        int dist = 1;


//        rungs = [3,6,8,10], dist = 3

        System.out.println(addRungs(rungs , dist));
    }

    public static int addRungs(int[] rungs, int dist) {

        if(rungs == null){
            return 0;
        }

        int res = 0;
        int len = rungs.length;
        int leftIndex = 0 , rightIndex = 1;
        if(rungs[leftIndex] - 0 > dist){
            if(rungs[leftIndex] % dist == 0){
                res += rungs[leftIndex] / dist -1 ;
            }else{
                res += rungs[leftIndex] / dist ;
            }

        }
        while(rightIndex < len){

            int cha = rungs[rightIndex] - rungs[leftIndex];

            if(cha > dist){
                if(cha % dist == 0){
                    res += cha / dist - 1;
                }else{
                    res += cha / dist;
                }

            }
            leftIndex++;
            rightIndex++;


        }

        return res;




    }



}
