

import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {

    private static TreeNode530 preNode ;
    private static int res ;


    public static class TreeNode530 {
        int val;
        TreeNode530 left;
        TreeNode530 right;
        TreeNode530(int x) { val = x; }
    }


    public static void main(String[] args) {



//        [90,69,null,49,89,null,52]
        TreeNode530 head = new TreeNode530(90);
        head.left = new TreeNode530(69);
        head.left.left = new TreeNode530(49);
        head.left.right = new TreeNode530(89);
        head.left.left.right = new TreeNode530(52);



        System.out.println(getMinimumDifference_mine(head));
        System.out.println("--------");
        System.out.println(getMinimumDifference(head));


    }

    private static int getMinimumDifference(TreeNode530 root) {

        if(root == null){
            return 0;
        }

        res = Integer.MAX_VALUE;

        preNode = null;

        helper(root);


        return res;

    }



    private static void helper(TreeNode530 node ){

        if(res == 1){return;}
        if(node == null){return;}

        helper(node.left );

        if(preNode != null){
            res = Math.min(res ,Math.abs(preNode.val - node.val));
        }

        preNode = node;

        helper(node.right);



    }


    public static int getMinimumDifference_mine(TreeNode530 root) {

        if(root == null){
            return 0;
        }

        ArrayList<Integer> arr = new ArrayList<>();

        helper_mine(root,arr);



        int res_mine = Integer.MAX_VALUE;

        int left = 0,right = 1;
        while(right < arr.size()){

            res_mine = Math.min(res_mine , arr.get(right) - arr.get(left));
            left++;
            right++;

        }




        return res_mine;



    }

    private static void helper_mine(TreeNode530 treeNode530,ArrayList<Integer> arr){


        if(treeNode530 != null){

            helper_mine(treeNode530.left,arr);
            arr.add(treeNode530.val);
            helper_mine(treeNode530.right,arr);

        }

    }



}
