
import java.util.*;

public class Solution_BackTrace {

    /*
     * 思路：回溯，使用数组存储LED数，回溯函数中使用两个int存储小时和分钟,时间复杂度：O（2^n）
     */
    public static void main(String[] args) {
        List<String> list = readBinaryWatch(1);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static List<String> readBinaryWatch(int num) {

        List<String> result = new ArrayList<>();
        if(num < 0){
            return null;
        }
        int[] leds = new int[]{8,4,2,1,32,16,8,4,2,1};
        backTrace(num ,leds , 0,0,0,result);

        return result;

    }

    private static void backTrace(int num , int[] leds ,int start ,int hour ,int minute,List<String> result){
        if(num == 0){
            // 要判断这个时候是否是正确的结果
            if(hour > 11 || minute > 59){
                return ;
            }

            StringBuilder stringBuilder = new StringBuilder() ;
            stringBuilder.append(hour+":");
            if(minute <10){
                stringBuilder.append("0");
            }
            stringBuilder.append(minute);

            result.add(stringBuilder.toString());
            return ;

        }

        for (int i = start; i < leds.length; i++) {

            // 回溯做选择
            if(i<4){
                hour += leds[i];
            }else{
                minute += leds[i];
            }

            backTrace(num-1,leds,i+1,hour,minute,result);

            // 回溯取消选择
            if(i<4){
                hour -= leds[i];
            }else{
                minute -= leds[i];
            }

        }



    }




}
