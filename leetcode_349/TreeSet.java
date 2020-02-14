import java.util.TreeSet;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums1.length ; i++){
            set.add(nums1[i]);
        }

        for(int i=0 ;i<nums2.length ;i++){
            if(set.contains(nums2[i]) == true){
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        for(int i=0;i<list.size() ; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}