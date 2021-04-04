/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    StringBuffer stringBuffer = new StringBuffer();
    int index = 0;
    TreeNode decodeRoot = new TreeNode();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root == null){
            return null;
        }


        serializeMain(root);

        String substring = stringBuffer.substring(0,stringBuffer.length()-1);


         return substring;
    }

    public void serializeMain(TreeNode root){

        if(root == null){
            stringBuffer.append("$,");
            return ;
        }

        stringBuffer.append(root.val+",");
        serializeMain(root.left);
        serializeMain(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
       if(data == null){
            return null;
        }
        if(data.length() == 0){
            return null;
        }


        String[] strings = data.split(",");
        if(strings[0].equals("$")){
            return null;
        }


        index = 0;
        decodeRoot = deserializeMain(decodeRoot,strings);





        return decodeRoot;
    }

    public TreeNode deserializeMain(TreeNode treeNode,String[] strings){
        int value;
        if(!strings[index].equals("$")){

            value = Integer.decode(strings[index]);

            treeNode = new TreeNode(value);



            ++index;
            TreeNode left = deserializeMain(treeNode.left,strings);

            ++index;
            TreeNode right = deserializeMain(treeNode.right,strings);

            treeNode.left = left;
            treeNode.right = right;
        }

        return treeNode;


    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));