import java.util.TreeMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int num : nums1){
            if(map.containsKey(num) == true){
                map.put(num,map.get(num) + 1);
            }
            else {
                map.put(num,1);
            }
        }

        for(int i=0;i<nums2.length ;i++){
            if(map.containsKey(nums2[i]) == true){
                list.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
                if( map.get(nums2[i]) == 0){
                    map.remove(nums2[i]);
                }
            }
            
        }

        int[] res = new int[list.size()];
        for(int i=0;i<list.size() ; i++){
            res[i] = list.get(i);
        }
        return res;
       

        
    }
}