

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {


        System.out.println(findTheWinner(6,5));

    }
    public static int findTheWinner(int n, int k) {

        if(n == 0 ){
            return 0;
        }else if(n == 1){
            return 1;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            arrayList.add(i);
        }



        int curIndex = 0;

        while(arrayList.size() > 1){

            curIndex += k-1;
            while(curIndex >= arrayList.size()){
                curIndex = curIndex - arrayList.size();

            }
            arrayList.remove(curIndex);


        }



        return arrayList.get(0);




    }

}
