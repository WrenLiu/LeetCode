import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        String num = "00123";



        System.out.println(getMinSwaps(num,  1));

//        System.out.println(nextPermutation(num));



    }

    public static int getMinSwaps(String num, int k) {

        if(num == null || k == 0){
            return 0;
        }

        String str = num;

        for (int i = 0; i < k; i++) {
            str = nextPermutation(str);
        }


        int len = str.length();
        int res = 0;

        int index ;


        // 实实在在的交换
        char[] str0 = num.toCharArray();
        char[] str1 = str.toCharArray();

        for (int i = 0; i < len; i++) {
            if(str0[i] != str1[i]){

                index = i + 1;
                while(str1[index] != str0[i]) {index ++;}

                while(index > i){
                    char tmp = str1[index] ;
                    str1[index] = str1[index-1];
                    str1[index - 1] = tmp;
                    res ++;  // 统计交换次数
                    index --;
                }


            }
        }





        return res;

    }

    public static String nextPermutation(String string) {

        char[] nums = string.toCharArray();

        int leftIndex = nums.length-2 , rightIndex = nums.length-1;

        while(leftIndex >= 0 && nums[leftIndex] >= nums[rightIndex]){
            leftIndex--;
            rightIndex--;
        }


        int indexK = nums.length - 1;
        while(indexK > rightIndex && nums[indexK] <= nums[leftIndex]){
            indexK--;
        }

        char tmp = nums[indexK] ;
        nums[indexK] = nums[leftIndex];
        nums[leftIndex] = tmp;

        Arrays.sort(nums,rightIndex , nums.length);



        return String.valueOf(nums);

    }
}
