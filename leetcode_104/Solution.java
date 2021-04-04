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
    public int maxDepth(TreeNode root) {

        if(root == null){
            return 0;
        }

        int nLeft = maxDepth(root.left);
        int nRight = maxDepth(root.right);

        return Math.max(nLeft,nRight) + 1;
    }

}