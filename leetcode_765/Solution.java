

public class Solution{

    public static void main(String[] args) {

        // 贪心算法：遍历偶数位置，找到他的朋友安排在它后面的奇数位置上
        int[] nums = {0, 2, 1, 3};

        System.out.println(minSwapsCouples(nums));

    }

    public static int minSwapsCouples(int[] row) {

        if(row == null){
            return -1;
        }

        int count = 0;
        for (int i = 0; i < row.length; i += 2) {

            int one = row[i];

            int two = find(one);

            if(row[i+1] != two){
                for (int j = i+2; j < row.length; j++) {

                    if(row[j] == two){
                        row[j] = row[i+1];
                        row[i+1]  =two;
                        count ++;
                    }

                }
            }




        }






        return count;

    }

    private static int find(int num){

        if(num % 2== 0){
            return num+1;
        }else {
            return num-1;
        }

    }


}
