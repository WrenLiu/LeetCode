

import DataStruct.ThreadedBinaryTree.TreeNode;

public class Solution {

    public static class TreeNode27 {
        int val;
        TreeNode27 left;
        TreeNode27 right;
        TreeNode27(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode27 treeNode = new TreeNode27(3);
        TreeNode27 treeNode1 = new TreeNode27(4);
        TreeNode27 treeNode2 = new TreeNode27(5);
        TreeNode27 treeNode3 = new TreeNode27(1);
        TreeNode27 treeNode4 = new TreeNode27(2);

        treeNode.left = treeNode1;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode.right = treeNode2;


        TreeNode27 root = mirrorTree(treeNode);

        midShow(root);
        System.out.println();
        System.out.println("Hello World");


    }

    private static void midShow(TreeNode27 root){

        if(root.left!=null){
            midShow(root.left);
        }

        System.out.print(root.val+" ");

        if(root.right != null){
            midShow(root.right);
        }

        return;

    }


    public static TreeNode27 mirrorTree(TreeNode27 root) {

        if(root == null){
            return null;
        }


        mirrorSubTree(root);

        return root;
    }


    private static void mirrorSubTree(TreeNode27 root){

        if(root.left == null && root.right == null){
            return;
        }

        TreeNode27 tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        if(root.left != null) {
            mirrorSubTree(root.left);
        }
        if(root.right != null) {
            mirrorSubTree(root.right);
        }

    }






}
