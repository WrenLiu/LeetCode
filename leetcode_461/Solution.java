
public class Solution {


    public static void main(String[] args) {

        int x  =1 , y = 4;

        System.out.println(hammingDistance(x,y));
    }

    public static int hammingDistance_leetcode(int x, int y) {

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int a = (x >> i) & 1 , b = (y >> i) & 1;
            ans += a ^ b;
        }
        return ans;
    }

    public static int hammingDistance(int x, int y) {

        if(x < 0 || y < 0){
            return 0;
        }
        String xStr = Integer.toBinaryString(x);
        String yStr = Integer.toBinaryString(y);

        int xIndex = xStr.length()-1;
        int yIndex = yStr.length()-1;

        int res = 0;
        while(xIndex >= 0 && yIndex >= 0){
            if((xStr.charAt(xIndex) == '1' && yStr.charAt(yIndex) == '0' ) || (xStr.charAt(xIndex) == '0' && yStr.charAt(yIndex) == '1')){
                res ++;
            }
            xIndex --;
            yIndex -- ;
        }


        while(xIndex >= 0){
            if(xStr.charAt(xIndex) == '1'){
                res++;
            }
            xIndex--;
        }

        while(yIndex >= 0){
            if(yStr.charAt(yIndex) == '1' ){
                res++;
            }
            yIndex --;
        }


        return res;


    }


}
