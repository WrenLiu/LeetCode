
import javax.jnlp.IntegrationService;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        List<Integer> list = getRow(3);

        System.out.println();
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }

    }

    public static List<Integer> getRow(int rowIndex) {

        if(rowIndex < 0){
            return null;
        }

        List<Integer> list01 = new ArrayList<>();
        List<Integer> list02 = new ArrayList<>();

        List<Integer>[] lists = new List[]{list01, list02};
        int flag = 0;


        lists[flag].add(1);
        if(rowIndex == 0 ){
            return lists[flag];
        }
        flag = 1 - flag;

        for (int i = 1; i < rowIndex+1; i++) {

            lists[flag].add(0,1);
            int j = 1;

            for ( ; j < i; j++) {
                lists[flag].add(j,lists[1-flag].get(j) + lists[1-flag].get(j-1));
            }

            lists[flag].add(j,1);

            flag = 1-flag;

            lists[flag].clear();

        }






        return lists[1-flag];


    }

    /**
     * 获取杨辉三角的指定行
     * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
     * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
     */
    public List<Integer> getRow_Leetcode(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }

}
