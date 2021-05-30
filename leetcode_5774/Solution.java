import java.util.*;

public class Solution5774 {


    public static void main(String[] args) {

//        int[] servers = {10,63,95,16,85,57,83,95,6,29,71};
//        int[] tasks = {70,31,83,15,32,67,98,65,56,48,38,90,5};

        int[] servers = {3,3,2};
        int[] tasks = {1,2,3,2,1,2};

        System.out.println(assignTasks(servers,tasks));

    }


    private static int[] assignTasks(int[] servers , int[] tasks){

        int[] res = new int[tasks.length];

        // 优先队列 busy 存储工作中的服务器，每一台服务器用二元组 (t,idx) 表示，其中 t 为该服务器结束工作的时间，idx 为该服务器的编号。
        // 优先队列的队首服务器满足 t 最小，并且在 t 相同的情况下，idx 最小。
        PriorityQueue<int[]> busy = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        //  优先队列 idle 存储空闲的服务器，每一台服务器用二元组 (w,idx) 表示，其中 w 为该服务器的 weight，
        //  idx 为该服务器的编号。优先队列的队首服务器满足 w 最小，并且在 w 相同的情况下 idx 最小。
        PriorityQueue<int[]> idle = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];

            }
        });


        for (int i = 0; i < servers.length; i++) {
            int[] arrTmp = new int[2];
            arrTmp[0] = servers[i];
            arrTmp[1] = i;
            idle.add(arrTmp);
        }

        int curTime = 0;

        for (int i = 0; i < tasks.length;) {

//      busy 存储工作中的服务器，每一台服务器用二元组 (t,idx) 表示，其中 t 为该服务器结束工作的时间，idx 为该服务器的编号。
//      idle 存储空闲的服务器，每一台服务器用二元组 (w,idx) 表示，其中 w 为该服务器的 weight，

            // 先处理 busy 队列,将任务结束的弹出队列
            while(!busy.isEmpty() && busy.peek()[0] <= curTime){
                int[] tmp = busy.poll();
                tmp[0] = servers[tmp[1]];
                idle.add(tmp);
            }


            // 同时有多台之前的任务没有Server去处理
            while(!idle.isEmpty() && i < tasks.length && i < curTime){

                int[] idleTmp = idle.poll();
                idleTmp[0] = curTime+tasks[i];
                busy.add(idleTmp);
                res[i] = idleTmp[1];
                i++;
            }

            // 直接使用curTime++会超时，当没有空闲服务器时，直接让curTime等于已使用服务器的最早结束值
            if (idle.isEmpty()) {
                curTime = busy.peek()[0];
            } else {
                curTime++;
            }



        }

        return res;

    }

}
