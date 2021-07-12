public class Solution {

    public static void main(String[] args) {


        String num  = "25??";
        System.out.println(sumGame(num));


    }

    public static boolean sumGame(String num) {

        int len = num.length();

        int presum = 0 ,postsum = 0  ,precnt = 0 , postcnt = 0;



        for (int i = 0; i < len / 2; i++) {

            if(num.charAt(i) != '?'){
                presum += num.charAt(i) - '0';
            }else{
                precnt ++;
            }
        }

        for (int i = len / 2; i < len; i++) {
            if(num.charAt(i) != '?'){
                postsum += num.charAt(i) - '0';
            }else{
                postcnt ++;
            }
        }

        // ? 个数为奇数,Alice必赢
        if((precnt + postcnt) % 2 != 0){
            return true;
        }else if(precnt == 0 && postcnt == 0){
            return postsum == presum;
        }

        // 算是一些结论吧
        //(1)presum > postsum，如果precnt >= postcnt，则Alice必赢（结论【3】）；
        // 如果precnt < postcnt，则return (postcnt - precnt) / 2 * 9 + postsum != presum（结论【2】）。
        //(2)presum == postsum，如果precnt == postcnt，前后问号两相抵消（结论【1】），Bob赢，否则，Alice赢。
        //(3)presum < postsum，与（1）同理。

        return 9 * (precnt - postcnt) / 2 + presum - postsum != 0;


    }




}
