class Solution {
    public int maxProfit(int[] prices) {

        if(prices == null){
            return -1;
        }
        if(prices.length <= 1){
            return 0;
        }

//        int[] dp = new int[prices.length];
//        int[] numMin = new int[prices.length];
//        numMin[0] = prices[0];
        int max = 0;
        int cost = prices[0];

        for(int price : prices)  {
            // 只记录前面的最小值
            cost = Math.min(price,cost);
            max = Math.max(price-cost, max );
        }



        return max;
    }

}