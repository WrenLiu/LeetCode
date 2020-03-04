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
    public int minDepth(TreeNode root) {
        return min(root);
    }

    private int min(TreeNode node){
        if(node == null){
            return 0;
        }

        int minLeft = minDepth(node.left);
        int minRight = minDepth(node.right);
        
        if(minLeft != 0 && minRight != 0 ){
            return Math.min(minLeft,minRight)+1;
            
        }
        else{ 
            return 1+Math.max(minLeft ,minRight) ;
        }
    

    }
}