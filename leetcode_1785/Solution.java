public class Solution {

    public static void main(String[] args) {

        int[] nums = {100000,100000,100000,100000,100000,100000,100000,100000,100000,100000};


        System.out.println(minElements(nums,1000000,-1000000000));

    }
    public static int minElements(int[] nums, int limit, int goal) {

        if(nums == null){
             return 0;
        }

        long currentTotal = 0;
        for (long num : nums) {
            currentTotal += num;
        }



        if(goal == currentTotal){
            return 0;
        }

        if((goal >= 0 && currentTotal >= 0 ) || (goal <= 0 && currentTotal <=0)){
            long cha = Math.max(Math.abs(goal),Math.abs(currentTotal)) - Math.min(Math.abs(goal),Math.abs(currentTotal));


            if(cha % Math.abs(limit) == 0){
                return (int) (cha / (long)Math.abs(limit));
            }else{

                return (int) (cha / Math.abs(limit) + 1);
            }
        }else{

            long cha = Math.abs(goal - currentTotal);

            if(cha % Math.abs(limit) == 0){
                return (int) (cha / Math.abs(limit));
            }else{

                return (int) (cha / Math.abs(limit) + 1);
            }


        }






    }


}
