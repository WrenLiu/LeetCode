

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {


        int[][] nums = {{2008,2026},{2004,2008},{2034,2035},{1999,2050},{2049,2050},{2011,2035},{1966,2033},{2044,2049}};

        System.out.println(maximumPopulation(nums));


    }

    public static int maximumPopulation(int[][] logs){

        if(logs == null){
            return 0;
        }

        int[] dp = new int[101];
        Arrays.fill(dp,0);
        for (int i = 0; i < logs.length; i++) {
            dp[logs[i][0] - 1950]++;
            dp[logs[i][1] - 1950]--;
        }


        int res = 0;
        int resYear = 1950;
        int cur = 0;
        for (int i = 0; i < 100; i++) {
            cur += dp[i];
            if(cur > res){
                resYear = 1950 + i;
                res = cur;
            }

        }

        return resYear;


    }

    public static int maximumPopulation_mine(int[][] logs) {

        if(logs == null){
            return 0;
        }

        HashMap<Integer , Integer> birth = new HashMap<>();
        HashMap<Integer,Integer> death = new HashMap<>();

        for (int i = 0; i < logs.length; i++) {
            birth.put(logs[i][0] , birth.getOrDefault(logs[i][0], 0)+1);
            death.put(logs[i][1] , death.getOrDefault(logs[i][1], 0)+1);
        }



        int maxPeople = 0;
        int res = -1;
        int lastPeople;

        if(birth.containsKey(1950)){
            lastPeople = birth.get(1950);
            maxPeople = lastPeople;
            res = 1950;
        }else{
            lastPeople = 0;
        }

        System.out.println(birth.get(2008)+" "+death.get(2008));


        for (int i = 1951; i <= 2050; i++) {

            int tmpPeople = lastPeople;
            if(birth.containsKey(i)){
                tmpPeople += birth.get(i);
            }
            if(death.containsKey(i)){
                tmpPeople -= death.get(i);
            }

            System.out.println(i+" "+tmpPeople);
            if(tmpPeople > maxPeople){
                maxPeople = tmpPeople;
                res = i;
            }

            lastPeople = tmpPeople;





        }

        return res;



    }


}
