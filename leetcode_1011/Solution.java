

public class Solution {


    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1};

//      15
        System.out.println(shipWithinDays_BinarySearch(nums,4));

    }

    public static int shipWithinDays_BinarySearch(int[] weights, int D) {

        if(weights == null){
            return 0;
        }


        int maxWeight = 0;
        int totalWeight = 0;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight , weight);
            totalWeight += weight;
        }

        int left = maxWeight;
        int right = totalWeight;

        int mid = 0;
        while(left <= right){

            mid = (left + right) >> 1;

            if(isOk(weights , mid , D)){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }

        return left;


    }

    private static boolean isOk(int[] ws, int t, int d) {
        int n = ws.length;
        int cnt = 1;
        for (int i = 1, sum = ws[0]; i < n; sum = 0, cnt++) {
            while (i < n && sum + ws[i] <= t) {
                sum += ws[i];
                i++;
            }
        }
        return cnt - 1 <= d;
    }

    public static int shipWithinDays_mine(int[] weights, int D) {

        if(weights == null){
            return 0;
        }

        int maxWeight = 0;
        int totalWeight = 0;
        for (int weight : weights) {
            maxWeight = Math.max(maxWeight , weight);
            totalWeight += weight;
        }

        if(D == 1){
            return totalWeight;
        }

        int total = maxWeight;
        int day = 0;
        System.out.println(total);
        while(total <= totalWeight){

            int index = 0;
            int tmp = total;
            day = 0;


            while(index < weights.length){

                tmp = total;
                while(index < weights.length && tmp-weights[index] >= 0){
                    tmp -= weights[index++];
                }
                day++;



                if(day > D){
                    break;
                }

            }

            if(day < D){
                return total;
            }

            if(day == D){
                return total;
            }

            if(day > D){
                total++;
            }



        }





        return day;



    }




}
