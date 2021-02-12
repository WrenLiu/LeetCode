

import java.util.ArrayList;
import java.util.List;

public class leetcode {

    public static void main(String[] args) {

        List<List<Integer>> lists = generate(0);

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> generate(int rowIndex) {
        if(rowIndex < 0){
            return null;
        }
        List<List<Integer>> lists = new ArrayList<>();
        if(rowIndex == 0){
            return lists;
        }

        List<Integer> listTmp = new ArrayList<>();
        listTmp.add(1);
        lists.add(listTmp);
        if(rowIndex == 1){
            return lists;
        }




        for (int i = 1; i < rowIndex; i++) {
            listTmp = new ArrayList<>();

            listTmp.add(1);
            int j = 1;
            for (; j < i; j++) {

                listTmp.add(j,lists.get(i-1).get(j)+ lists.get(i-1).get(j-1));

            }
            listTmp.add(1);

            lists.add(listTmp);


        }




        return lists;




    }


}
