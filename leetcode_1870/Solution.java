
public class Solution {

    public static void main(String[] args) {


        int[] dist = {2,1,5,4,4,3,2,9,2,10};
        double hour = 75.12;

        System.out.println(minSpeedOnTime(dist , hour));

    }

    private static int minSpeedOnTime(int[] dist, double hour) {

        if(dist.length > Math.ceil(hour)){
            return -1;
        }

//        8388608
        // 二分实现

        int total =0 ;
        int maxLen = 0;

        double lasthour = hour - Math.floor(hour) == 0.0 ? 1.0 : hour - Math.floor(hour);

        for (int i : dist) {
            total += i;
            maxLen = Math.max(maxLen , i);
        }

        // 最小的速度是总里程除以时间
        int minSpeed = (int)(total / hour) > 0 ? (int)(total / hour) : 1;
        // 最大的时间是最长的一段在1个小时内跑完或者最后的一段在hour小数点的时间内跑完
        int maxSpeed = Math.max(maxLen , (int)Math.ceil(dist[dist.length-1] / lasthour ));
        
        while(minSpeed <= maxSpeed){
            
            int midSpeed = minSpeed + (maxSpeed - minSpeed) / 2;
            
            if(check(dist,hour,midSpeed)){
                maxSpeed = midSpeed - 1;
            }else{
                minSpeed = midSpeed + 1;
            }
        }

        return minSpeed;

    }

    private static boolean check(int[] dist , double hour , int curSpeed){

        double curTime = 0.0;

        for (int i = 0; i < dist.length -1; i++) {
            curTime += (dist[i] + curSpeed - 1) / curSpeed;
        }

        curTime += (double) dist[dist.length-1] / curSpeed;

        return curTime <= hour;
        
    }

}
