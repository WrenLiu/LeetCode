
import java.util.Arrays;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {

        int[] citations = {1,3,1};

        System.out.println(hIndex(citations));

    }

    public static int hIndex_leetcode(int[] nums) {
        if(nums == null){
            return 0;
        }

        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {

            int h = len - i;
            if(h <= nums[i]){
                return h;
            }

        }

        return 0;

    }

    static TreeMap<Integer , Integer> treeMap;
    static TreeMap<Integer , Integer> countMap ;
    // 0 1 3 5 6
    public static int hIndex(int[] nums) {

        if(nums == null){
            return 0;
        }

        Arrays.sort(nums);
        int len = nums.length;
        int maxIndex = nums[len-1];
        treeMap = new TreeMap<>();
        countMap = new TreeMap<>();

        for (int num : nums) {
            treeMap.put(num , treeMap.getOrDefault(num , 0)+1);
        }

        for (Integer integer : treeMap.keySet()) {
            if(integer == treeMap.firstKey()){
                countMap.put(integer , len);
                continue;
            }

            int preNum = treeMap.floorKey(integer-1);


            countMap.put(integer , countMap.get(preNum) - treeMap.get(preNum));
        }

        int leftIndex = 0 ;
        int rightIndex = maxIndex;

        
        // 这里其实最大值就是len,因为你要保证有足够数量的论文
        while(leftIndex <= rightIndex){

            int mid = (rightIndex - leftIndex) / 2 + leftIndex;

            if(isOk(mid)){
                leftIndex = mid + 1;
            }else{
                rightIndex = mid - 1;
            }
        }



        return rightIndex;

    }

    private static boolean isOk(int index){

        int nextNum = countMap.ceilingKey(index);

        int count = countMap.get(nextNum);

        return count >=  index;
    }


}
