
public class Solution {


    public static void main(String[] args) {

        int[] chalk = {3,4,1,2};
        int k = 3;



        System.out.println(chalkReplacer(chalk , k));
    }

    public static int chalkReplacer(int[] chalk, int k) {

        if(chalk == null || chalk.length == 0){
            return 0;
        }

        int index = 0;
        int n = chalk.length;

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += chalk[i];
            if(total > k){
                return i;
            }


        }

        if(total < k){
            k = k % total;
        }
        System.out.println(k);

        while(k >= 0){

            k -= chalk[index];
            System.out.println(k);
            if(k < 0){
                return index;
            }
            index++;

            if(index == n){
                index = 0;
            }


        }

        return index;


    }



}
