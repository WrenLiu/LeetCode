
import java.util.*;

public class Solution {

    public static void main(String[] args) {

//        int[] nums = {0,0};
        int[] nums = {10,2};
//        9534330

//        "83083088308"
//        "83088308830"
//        8308
        System.out.println(largestNumber(nums));


    }

    public static String largestNumber(int[] nums) {


        if(nums == null || nums.length == 0){
            return "";
        }

        if(nums.length == 1){
            return nums[0]+"";
        }

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            arrayList.add( nums[i]+"" );
        }

        Collections.sort(arrayList, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {

                String s1 = (String) o1 + "" + (String)o2;
                String s2 = (String) o2 + "" + (String)o1;
                return s1.compareTo(s2) ;
            }
        });


        String res = "";
        for (int i = arrayList.size()-1; i >= 0 ; i--) {
            res += arrayList.get(i)+"";
        }


        if(res.charAt(0) == '0'){
            return "0";
        }


        return res;

    }


}
