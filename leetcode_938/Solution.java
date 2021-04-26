import java.util.ArrayList;

public class Solution{

    static class TreeNode938 {
        int val;
        TreeNode938 left;
        TreeNode938 right;
        TreeNode938() {}
        TreeNode938(int val) { this.val = val; }
        TreeNode938(int val, TreeNode938 left, TreeNode938 right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static ArrayList<Integer> array ;
    private static int sum;



    public static void main(String[] args) {
        TreeNode938 root = new TreeNode938(10);

        System.out.println(rangeSumBST_mine(root,10,20));




    }

    private static int rangeSumBST(TreeNode938 root, int low, int high) {


        if(root == null){
            return 0;
        }

        if(root.val <= high && root.val >= low){
            return root.val + rangeSumBST(root.left , low , high) + rangeSumBST(root.right ,low ,high);
        }else if(root.val < low){
            return rangeSumBST(root.right , low ,high);
        }else if(root.val > high){
            return rangeSumBST(root.left , low, high);
        }

        return 1;

    }

    public static int rangeSumBST_mine(TreeNode938 root, int low, int high) {

        if(root == null){
            return 0;
        }

        array = new ArrayList<>();
        sum = 0;


        middle(root,low , high);

        return sum;


    }

    private static void middle(TreeNode938 node, int low , int high){


        if(node != null){

            middle(node.left,low,high);
            if(node.val <= high && node.val >= low){
                sum += node.val;
            }

            middle(node.right , low ,high);



        }

    }


}
