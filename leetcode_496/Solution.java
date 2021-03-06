import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};

        System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2)));

    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null ){
            return null;
        }

        int[] res = new int[nums1.length];


        HashMap<Integer,Integer> hashMap = new HashMap<>();

        Stack<Integer> stack = new Stack<>();



        // 单调栈实现
        for (int indexArr = 0; indexArr < nums2.length; indexArr++) {
            int tmpNum = nums2[indexArr];

            while(!stack.isEmpty() && nums2[stack.peek()] < tmpNum ){
                hashMap.put(nums2[stack.pop()],tmpNum);
            }

            stack.push(indexArr);
        }


        for (int i = 0; i < nums1.length; i++) {

            if(hashMap.containsKey(nums1[i])){
                res[i] = hashMap.get(nums1[i]);
            }else {
                res[i] = -1;
            }

        }


        return res;


    }



}
