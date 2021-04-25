import java.util.ArrayList;

public class Solution {

    static class TreeNode897 {
        int val;
        TreeNode897 left;
        TreeNode897 right;
        TreeNode897() {}
        TreeNode897(int val) { this.val = val; }
        TreeNode897(int val, TreeNode897 left, TreeNode897 right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static ArrayList<Integer> arr ;


    public static void main(String[] args) {

        TreeNode897 root = new TreeNode897(5);

        root.left = new TreeNode897(3);
        root.right = new TreeNode897(6);

        TreeNode897 newRoot  = increasingBST(root);
        
    }

    public static TreeNode897 increasingBST(TreeNode897 root) {

        if(root == null){
            return null;
        }

        arr = new ArrayList<>();

        midShow(root);

        int index = 1;

        TreeNode897 res = new TreeNode897(arr.get(0));
        TreeNode897 tmpNode = res;
        while(index < arr.size()){

            tmpNode.right = new TreeNode897(arr.get(index++));
            tmpNode = tmpNode.right;

        }


        return res;
    }

    private static void midShow(TreeNode897 node){

        if(node == null){
            return;
        }

        midShow(node.left);
        arr.add(node.val);
        midShow(node.right);
    }



}
