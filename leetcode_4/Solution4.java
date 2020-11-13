package WebTest.LeetCode;

import sun.reflect.generics.tree.Tree;

import java.util.TreeSet;

/**
 * 难！！！
 *
 * 对于这种解法 我的思考就是滑轮理论
 * 想象一下在nums1和nums2上有两个滑轮 滑轮每次滑动的距离是 k/2 （滑动距离是递减的，类似于缓冲，比如下一次滑动距离就是（k-k/2）/2），当然这个滑动距离可以是1，也就是滑一下比较一下，滑k/2是为了使用二分法将算法复杂度变成O(log(m+n)),滑1那复杂度不就是传统解法O(m+n)了
 * k是什么，k是两个滑轮总共可以滑动的总距离，假设s1是nums1上滑动的距离，s2是num2上滑动的距离，s1 + s2 = k-1
 * 那滑动方式是怎么判定的呢？ 因为数组是从小到大排列的，在k处的值肯定是大于前面的值，所以滑动方式是谁小谁滑
 * 开始：滑轮1滑动k/2和滑轮2滑动k/2-1，谁小谁再滑(k-k/2)/2
 * 结束：直到某一个滑轮滑出边界了，或者某一个滑轮滑到了距离k
 * @param nums1  数组1
 * @param index1 数组1的索引
 * @param nums2  数组2
 * @param index2 数组2的索引
 * @param k    距离目标中位数的距离
 * @return int
 */

public class Solution4 {

    public static void main(String[] args) {

        int nums1[] = {1};
        int nums2[] = {1};

        System.out.println(findMedianSortedArrays(nums1,nums2));

    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // 为了找排在一起的数组中的第(left-1)项和第(right-1)项，
        // 如果是总共有奇数个，left=right；如果总共有偶数个，(res[left-1]+res[right-1])/2是中位数
        int left = (m+n+1)/2;
        int right =(m+n+2)/2;

        return (solCore(nums1,0,nums2,0,left) + solCore(nums1,0,nums2,0,right))/2.0;

    }

    private static double solCore(int[] nums1, int index1,int[] nums2,int index2,int k){
        // 滑轮出界
        if(index1 >= nums1.length){return nums2[index2+k-1];}
        if(index2 >= nums2.length){return nums1[index1+k-1];}

        // 两个滑轮共滑到了距离k-1
        if(k == 1){ return Math.min(nums1[index1],nums2[index2]); }

        int midVal1 = (index2 + k/2-1 < nums1.length) ? nums1[index1+k/2-1] :Integer.MAX_VALUE;
        int midVal2 = (index2 + k/2-1 < nums2.length) ? nums2[index2+k/2-1] :Integer.MAX_VALUE;

        // 谁小谁再滑(k-k/2)/2
        if(midVal1 < midVal2){
            return solCore(nums1,index1+k/2 ,nums2, index2, k-k/2);
        }else{
            return solCore(nums1,index1 ,nums2 , index2+k/2 , k-k/2);
        }

    }


    public static double findMedianSortedArrays_(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null){ return 0.0; }
        if(nums1.length == 0 && nums2.length != 0){ return work(nums2); }
        if(nums1.length != 0 && nums2.length == 0){ return work(nums1); }
        if(nums1.length == 0 && nums2.length == 0){ return 0; }

        int index1 = 0,index2= 0 ,index_res = 0;
        int result[] = new int[nums1.length+nums2.length];

        for (int i = 0; i < nums1.length + nums2.length; i++) {
            if(index1 == nums1.length){
                for (; index2 < nums2.length; index2++) {
                    result[index_res++] = nums2[index2];
                }
                break;
            }
            if(index2 == nums2.length){
                for (; index1 < nums1.length; index1++) {
                    result[index_res++] = nums1[index1];
                }
                break;
            }

            if(nums1[index1] > nums2[index2]){
                result[index_res++] = nums2[index2++];
            }else if(nums1[index1] < nums2[index2]){
                result[index_res++] = nums1[index1++];
            }else{
                result[index_res++] = nums1[index1++];
                result[index_res++] = nums2[index2++];
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }


        return work(result);

    }

    private static double work(int[] num){
        if(num.length % 2 == 1){
            return num[num.length/2];
        }else{

            return num[num.length/2]==num[num.length/2-1] ? num[num.length/2] :  (num[num.length/2]+num[num.length/2-1])/2.0;
        }
    }

}
