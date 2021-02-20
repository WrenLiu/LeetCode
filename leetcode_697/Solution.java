
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution{

    public static void main(String[] args) {

        int[] nums = {1,2,2,3,1,4,2};
//        int[] nums = {1};

        // 时间都比较差，都是基于哈希
//        System.out.println(findShortestSubArray(nums));
//        System.out.println(findShortestSubArray02(nums));

        // 基于数组，时间要好
        System.out.println(findShortestSubArray03(nums));


    }

    private static int findShortestSubArray03(int[] nums){

        if(nums == null){
            return -1;
        }

        if(nums.length == 0){
            return 0;
        }

        final int N = 50000;


        int[] cnt = new int[N];
        int[] first = new int[N] ,last = new int[N];

        Arrays.fill(first,-1);

        int maxDegree = 0;

        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];

            // 其实cnt就相当于哈希表，存储的Key就是某个数，cnt[t]就是哈希的value，即 度
            maxDegree = Math.max(maxDegree,++cnt[t]);

            // first和last就是左右指针
            if(first[t] == -1){
                first[t] = i;
            }
            last[t] = i;
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if(cnt[nums[i]] == maxDegree) {
                ans = Math.min(ans, last[nums[i]] - first[nums[i]] + 1);
            }
        }

        return ans;



    }

    public static int findShortestSubArray(int[] nums) {

        if(nums == null){
            return -1;
        }

        if(nums.length == 0){
            return 0;
        }

        int[] maxNums = findMax(nums);

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int num : nums) {
            arrayList.add(num);
        }

        int minChannel = Integer.MAX_VALUE;


        for (int i = 0; i < maxNums.length; i++) {
            minChannel = Math.min(minChannel,arrayList.lastIndexOf(maxNums[i]) - arrayList.indexOf(maxNums[i]) + 1);
        }





        return minChannel;





    }

    private static int[] findMax(int[] nums){

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            }else{
                hashMap.put(nums[i],1);
            }
        }

        int max = 0;
        ArrayList<Integer> tmp = new ArrayList<>();

        for (Integer integer : hashMap.keySet()) {
            if(max < hashMap.get(integer)){
                tmp = new ArrayList<>();
                max = hashMap.get(integer);
                tmp.add(integer);
            }else if(max == hashMap.get(integer)){
                tmp.add(integer);
            }else {
                continue;
            }
        }

        int[] res = new int[tmp.size()];
        int index = 0;
        for (Integer integer : tmp) {
            res[index++] = integer;
        }

        return res;




    }

    public static int findShortestSubArray02(int[] nums) {

        if(nums == null){
            return -1;
        }

        if(nums.length == 0){
            return 0;
        }


        int maxDegree = getdegree(nums);
        int left = 0,right = 0,res = nums.length+1;

        // Key 是每种数，Value是基于此数的度
        HashMap<Integer ,Integer> hashMap = new HashMap<>();

        while(right < nums.length){

            hashMap.put(nums[right],hashMap.getOrDefault(nums[right],0)+1);

            while(hashMap.get(nums[right]) == maxDegree){
                hashMap.put(nums[left],hashMap.get(nums[left])-1);
                res = Math.min(res,right -left + 1);
                left++;
            }

            right++;
        }

        for (Integer integer : hashMap.keySet()) {
            System.out.println(integer+" "+hashMap.get(integer));
        }

        return res;


    }

    private static int getdegree(int[] nums){

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        int res = 0;

        for (int num : nums) {
            // 如果有就加1，如果没有就初始化Value为0
            hashMap.put(num,hashMap.getOrDefault(num,0) + 1);
            res = Math.max(res,hashMap.get(num));
        }

        return res;


    }



}
