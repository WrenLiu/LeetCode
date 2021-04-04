/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    private static TreeNode rootForPQ = null;
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    if( root == null || p == null || q == null ){
        return null;
    }

    if(p == q) {
        return p;
    }

    TreeNode nodeMin,nodeMax;
    if(p.val > q.val){
        nodeMin = q;
        nodeMax = p;
    }else{
        nodeMin = p;
        nodeMax = q;
    }


    lowestCommonAncestor_helper(root ,nodeMin,nodeMax);



    return rootForPQ;
}

private static void lowestCommonAncestor_helper(TreeNode root,TreeNode nodeMin ,TreeNode nodeMax ){


    if(root == null){
        return;
    }


    if(root.val <= nodeMax.val && root.val >= nodeMin.val){
        rootForPQ = root;

    }else if(root.val < nodeMin.val ){

        lowestCommonAncestor_helper(root.right,nodeMin,nodeMax);

    }else if(root.val > nodeMax.val){
        lowestCommonAncestor_helper(root.left,nodeMin,nodeMax);

    }


}
}