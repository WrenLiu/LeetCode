

import java.util.ArrayList;

public class Solution {

    static class TreeNode872 {
        int val;
        TreeNode872 left;
        TreeNode872 right;
        TreeNode872() {}
        TreeNode872(int val) { this.val = val; }
        TreeNode872(int val, TreeNode872 left, TreeNode872 right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    
    public static void main(String[] args) {
        
    }

    public static boolean leafSimilar(TreeNode872 root1, TreeNode872 root2) {

        if(root1 == null || root2 == null){
            return false;
        }

        ArrayList<Integer> arr01 = new ArrayList<>();
        ArrayList<Integer> arr02 = new ArrayList<>();

        midshow(root1, arr01);
        midshow(root2, arr02);


        if(arr01.size() != arr02.size()){
            return false;
        }


        for (int i = 0; i < arr01.size(); i++) {
            if(arr01.get(i) != arr02.get(i)){

                return false;
            }
        }


        return true;

    }

    private static void midshow (TreeNode872 node,ArrayList<Integer> arr){

        if(node == null){
            return;
        }


        midshow(node.left,arr);

        if(node.left == null && node.right == null){
            arr.add(node.val);
        }

        midshow(node.right,arr);

    }



}
