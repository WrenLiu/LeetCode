import java.util.*;

public class Solution {

    static class Task{
        int id;
        int enqueueTime;
        int processingTime;

        public Task(int id, int enqueueTime, int processingTime){
            this.id = id;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }

    public static void main(String[] args) {

        int[][] tasks = {{1,2},{2,4},{3,2},{4,1}};
        System.out.println(Arrays.toString(getOrder(tasks)));

    }

    public static int[] getOrder(int[][] tasks) {
        if(tasks == null){
            return null;
        }

        ArrayList<Task> taskList = new ArrayList<>();

        for (int i = 0; i < tasks.length; i++) {
            taskList.add(new Task(i,tasks[i][0],tasks[i][1]));
        }

        Collections.sort(taskList , ((t1, t2) -> ( t1.enqueueTime - t2.enqueueTime)));

        PriorityQueue<Task> minHeap = new PriorityQueue<>((t1,t2) -> {
            if(t1.processingTime == t2.processingTime){
                // 执行时间相同
                return t1.id - t2.id;
            }else{
                // 执行时间不同
                return t1.processingTime - t2.processingTime;
            }
        });

        int index = 0;
        long nowTime = 0;

        int len = tasks.length;
        int[] res = new int[len];
        int resIndex= 0;

        while(index < len){

            // 将所有的入队时间小于当前时间的放入堆中
            while(index < len && taskList.get(index).enqueueTime <= nowTime) {
                minHeap.offer(taskList.get(index));
                index++;
            }

            if(minHeap.isEmpty()){
                nowTime = (long)taskList.get(index).enqueueTime;

                while(index < len && taskList.get(index).enqueueTime <= nowTime) {
                    minHeap.offer(taskList.get(index));
                    index++;
                }
            }

            Task task = minHeap.poll();
            res[resIndex++] = task.id;
            nowTime += task.processingTime;

        }

        while(!minHeap.isEmpty()) {
            res[resIndex++] = minHeap.poll().id;
        }




        return res;




    }


}
