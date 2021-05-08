import java.util.Arrays;


public class Solution {

    private static int maxJob ;
    private static int k;
    private static int[] jobs;

    public static void main(String[] args) {

        int[] nums = {1,2,4,7,8};
        System.out.println(minimumTimeRequired(nums,2));

    }

    public static int minimumTimeRequired(int[] _jobs, int _k) {

        if(_jobs == null || _k == 0){
            return 0;
        }

        maxJob = Integer.MAX_VALUE;

        k = _k;
        jobs = Arrays.copyOf(_jobs , _jobs.length);

        int[] jobAmount = new int[k];

        helper(0,0 , jobAmount, 0);

        return maxJob;

    }

    // jobIndex : 第 index 个工作
    // max 当前的最大工作量
    // used 当前分配给工作了的最大的工人编号 , 比如当前只给 0,1 工人有工作,那么used就是1,于是下一份优先分配给没工作的2
    // jobAmount : 第 i 个工人的工作量
    private static void helper(int jobIndex , int used ,int[] jobAmount ,int max  ){

        if(max >= maxJob){
            return;
        }

        if( jobIndex == jobs.length){
            maxJob = max;
            return ;
        }

        // 优先分配给「空闲工人」
        // 如果没有这一步，那么最开始深度遍历就是将全部工作给0号工人
        // 所以先平摊给每个工人一份工作
        if (used < k) {

            jobAmount[used] = jobs[jobIndex];
            helper(jobIndex + 1, used + 1, jobAmount, Math.max(jobAmount[used], max));
            jobAmount[used] = 0;
        }

        for (int i = 0; i < used; i++) {

            jobAmount[i] += jobs[jobIndex];
            helper(jobIndex+1 ,used, jobAmount , Math.max(max , jobAmount[i]));
            jobAmount[i] -= jobs[jobIndex];

        }

    }



}
