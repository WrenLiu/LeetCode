import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int[] nums = {100,100,100};

        System.out.println(Arrays.toString(arrayRankTransform(nums)));
        System.out.println(Arrays.toString(arrayRankTransform_mine(nums)));

    }

    public static int[] arrayRankTransform(int[] arr){
        if(arr == null || arr.length == 0){
            return arr;
        }
        int[] newArr = arr.clone();
        Arrays.sort(newArr);
        int[] res = new int[arr.length];

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        int count = 1;

        for (int i = 0; i < newArr.length; i++) {
            if(!hashMap.containsKey(newArr[i])){
                hashMap.put(newArr[i] , count);
                count++;
            }
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = hashMap.get(arr[i]);
        }


        return res;

    }

    public static int[] arrayRankTransform_mine(int[] arr) {

        if(arr == null){
            return null;
        }

        int[] res = new int[arr.length];

        TreeSet<int[]> set = new TreeSet<>(new MyComparator());

        for (int i = 0; i < arr.length; i++) {
            int[] tmp = {arr[i] , i};
            set.add(tmp);
        }

        int index = 1;

        int[] tmp = set.pollFirst();
        res[tmp[1]] = 1;
        int lastNum = tmp[0];

        while(!set.isEmpty()){
            tmp = set.pollFirst();
            if(lastNum == tmp[0]){
                res[tmp[1]] = index;
                lastNum = tmp[0];
                continue;
            }
            index++;
            res[tmp[1]] = index;
            lastNum = tmp[0];

        }


        return res;

    }

    static class MyComparator implements Comparator<int[]> {

        // 参数1  相当于  调用者    参数2 相当于 参数
        @Override       // this--o1     o --> o2
        public int compare(int[] o1, int[] o2) {
            if(o1[0] != o2[0]){
                return o1[0] - o2[0];
            }else{
                return o1[1] - o2[1];
            }

        }
    }


}
