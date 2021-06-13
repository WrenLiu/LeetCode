

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        String s = "abcacb", p = "ab"; // 2
        int[] removable = {3,1,0};

//         String s = "abcbddddd", p = "abcd"; // 1
//         int[] removable = {3,2,1,4,5,6};

//        String s = "abcab", p = "abc"; // 0
//        int[] removable = {0,1,2,3,4};

//        String s = "qlevcvgzfpryiqlwy" , p = "qlecfqlw";  // 2
//        int[] removable = {12,5};

//        isSubStringNew(s ,  p, 1,removable);


        System.out.println(maximumRemovals(s , p ,removable));

    }



    public static int maximumRemovals(String s, String p, int[] removable){

        //   通过二分查找确定使得该判定问题成立的最大的 k

        int left = 0 , right = removable.length ;

        while(left <= right){
            int mid = left + (right - left) / 2;


            if(isSubStringNew(s , p , mid , removable)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }


        return right;

    }

    private static boolean isSubStringNew(String s ,String p , int k, int[] removable){

        char[] sChaArr = s.toCharArray();

        for (int i = 0; i < k; i++) {
            sChaArr[removable[i]] = ' ';
        }

        int sIndex = 0;
        int pIndex = 0;
        while(pIndex < p.length() && sIndex < sChaArr.length){

            if(p.charAt(pIndex) == sChaArr[sIndex]){
                pIndex++;
                sIndex++;
            }else{
                sIndex++;
            }
            if(pIndex == p.length())
                return true;

        }


        return false;

    }











    private static boolean isSubString(StringBuffer s_sb , String p ){

        int preIdnex = s_sb.indexOf(p.charAt(0)+"");
        if(preIdnex < 0){
            return false;
        }

        for (int i = 1; i < p.length(); i++) {

            int curIndex = s_sb.substring(preIdnex+1).indexOf(p.charAt(i)+"");
            if(curIndex>=0){
                preIdnex = curIndex + preIdnex + 1;
            }else{
                return false;
            }

        }

        return true;
    }

    public static int maximumRemovals_mine(String s, String p, int[] removable) {

        int len = removable.length;

        StringBuffer s_sb = new StringBuffer(s);


        for (int res = 0; res < len ; res++) {

            s_sb.replace(removable[res],  removable[res]+1,  " ");
            System.out.println(s_sb);

            if(!isSubString(s_sb , p )){
                return res ;
            }
//            s_sb.replace(removable[res-1], removable[res - 1]+1 , s.charAt(removable[res-1])+"");
        }

        return 0;

    }



}
