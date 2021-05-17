

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class Solution {

    static class TreeNode993 {
        int val;
        TreeNode993 left;
        TreeNode993 right;
        TreeNode993() {}
        TreeNode993(int val) { this.val = val; }
        TreeNode993(int val, TreeNode993 left, TreeNode993 right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {

        TreeNode993 root = new TreeNode993(1);
        root.left = new TreeNode993(2);
        root.right = new TreeNode993(3);
        root.left.right = new TreeNode993(4);
        root.right.right = new TreeNode993(5);

        System.out.println(isCousins_bfs_02(root,4,5));
        System.out.println(isCousins_bfs(root,4,5));

    }

    public static boolean isCousins_bfs_02(TreeNode993 root, int x, int y) {

        if(root == null){
            return false;
        }

        Deque<Object[]> deque = new ArrayDeque<>();
        deque.addLast(new Object[]{root ,null , 0});

        int curFloorSize = 0;
        while(! deque.isEmpty()) {
            curFloorSize = deque.size();

            int[] arr = new int[4];
            int arrIndex = 0;

            while(curFloorSize -- > 0){

                Object[] pollNode = deque.pollFirst();

                TreeNode993 curNode = (TreeNode993)pollNode[0], father = (TreeNode993)pollNode[1];
                int curdeep = (Integer)pollNode[2];

                if((curNode.val == x || curNode.val == y) && (father != null)){
                    arr[arrIndex] = curdeep;
                    arr[arrIndex+2] = father.val;
                    arrIndex++;

                }

                if(curNode.left  != null){ deque.addLast(new Object[]{curNode.left ,curNode , curdeep+1});}
                if(curNode.right != null){ deque.addLast(new Object[]{curNode.right,curNode , curdeep+1});}



            }

            if(arr[0] == arr[1] && arr[2] != arr[3]){
                return true;
            }




        }




        return false;
    }

    public static boolean isCousins_bfs(TreeNode993 root, int x, int y) {

        if(root == null){
            return false;
        }

        // 0 是 深度 ； 1 是 父节点值

        int[] deep_x = helper_bfs(root,x );
        int[] deep_y = helper_bfs(root,y );


        return deep_x[0] == deep_y[0] && deep_x[1] != deep_y[1];
    }

    private static int[] helper_bfs(TreeNode993 root ,int val ){

        // Object[] 分别存储 （cur ,father,depth）
        Deque<Object[]> queue = new ArrayDeque<>();

        queue.addLast(new Object[]{root ,null , 0});

        while(! queue.isEmpty()){

            int size = queue.size();
            while(size-- > 0){

                Object[] pollNode = queue.pollFirst();

                TreeNode993 cur = (TreeNode993)pollNode[0], father = (TreeNode993)pollNode[1];

                int curdeep = (Integer)pollNode[2];

                // 0 是 深度 ； 1 是 父节点值

                // 找到了节点
                if(cur.val == val){ return new int[]{curdeep , father != null ? father.val : 0} ; }
                if(cur.left != null){ queue.addLast(new Object[]{cur.left , cur , curdeep+1});}
                if(cur.right != null){queue.addLast(new Object[]{cur.right,cur , curdeep+1});}


            }


        }


        return new int[]{-1, -1};


    }

    // dfs
    public static boolean isCousins_dfs(TreeNode993 root, int x, int y) {

        if(root == null){
            return false;
        }


        // 0 是 深度 ； 1 是 父节点值
        int[] deep01 = new int[2];
        Arrays.fill(deep01,-1);
        int[] deep02 = new int[2];
        Arrays.fill(deep02,-1);

        midshow_01(root, x, 0, deep01);
        midshow_01(root, y, 0, deep02);


        if(deep01[0] == deep02[0] && deep01[1] != -1 && deep02[1] != -1 && deep01[1] != deep02[1]){
            return true;
        }else{
            return false;
        }

    }

    private static void midshow_01(TreeNode993 node, int val, int curDeep,  int[] deep){

        if(node == null){
            return ;
        }

        if(node.left != null ){

            if(node.left.val == val){

                deep[0] = curDeep+1;
                deep[1] = node.val;
                return ;
            }else{
                midshow_01(node.left,val , curDeep+1,deep);
            }
        }

        if(node.right != null){
            if(node.right.val == val){

                deep[0] = curDeep+1;
                deep[1] = node.val;
                return ;
            }else{
                midshow_01(node.right ,val , curDeep+1,deep);
            }
        }

        return ;



    }




}
