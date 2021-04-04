

import DataStruct.ThreadedBinaryTree.TreeNode;

import java.util.*;

public class Solution {
    public static class TreeNode32 {
        int val;
        TreeNode32 left;
        TreeNode32 right;
        TreeNode32(int x) { val = x; }
    }

    public static void main(String[] args) {

        TreeNode32 treeRoot =  new TreeNode32(3);
        TreeNode32 treeNode1 = new TreeNode32(9);
        TreeNode32 treeNode2 = new TreeNode32(20);
        TreeNode32 treeNode3 = new TreeNode32(15);
        TreeNode32 treeNode4 = new TreeNode32(7);

        treeRoot.left  = treeNode1;
        treeRoot.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right= treeNode4;

//        midShow(treeRoot);

        // 第一题
//        levelOrder_01(treeRoot);
//
//        // 第二题
//        levelOrder_02(treeRoot);

        List<List<Integer>> list = levelOrder_03(treeRoot);

        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }



        System.out.println("Hello World;");

    }

    private static void midShow(TreeNode32 root){

        if(root.left!=null){
            midShow(root.left);
        }

        System.out.print(root.val+" ");

        if(root.right != null){
            midShow(root.right);
        }

        return;
    }

    public static int[] levelOrder_01(TreeNode32 root) {

        if(root == null){
            return new int[0];
        }

        ArrayDeque<TreeNode32> arrayDeque = new ArrayDeque<>();
        ArrayList<TreeNode32> arrayList = new ArrayList<>();
        arrayDeque.add(root);

        while(!arrayDeque.isEmpty()){

            if(arrayDeque.peekFirst().left != null){
                arrayDeque.add(arrayDeque.peekFirst().left);
            }

            if(arrayDeque.peek().right != null){
                arrayDeque.add(arrayDeque.peekFirst().right);
            }

            arrayList.add(arrayDeque.peekFirst());
            arrayDeque.removeFirst();

        }

        int[] result = new int[arrayList.size()];
        int index = 0;
        for (TreeNode32 treeNode32 : arrayList) {
            result[index++] = treeNode32.val;
        }

        return result;

    }

    public static List<List<Integer>> levelOrder_02(TreeNode32 root) {

        List<List<Integer> > list = new ArrayList<>();

        if(root == null){
            return list;
        }

        List<Integer> listInner = new ArrayList<>();

        ArrayDeque<TreeNode32> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(root);
        int curLevel = 1;
        int nextLevel= 0;

        while(!arrayDeque.isEmpty()){

            if(curLevel == 0){
                curLevel = nextLevel;
                nextLevel = 0;
                list.add(listInner);
                listInner = new ArrayList<>();;
//                System.out.println("-------");
            }

            if(arrayDeque.peekFirst().left != null){
                arrayDeque.add(arrayDeque.peekFirst().left);
                nextLevel++;
            }

            if(arrayDeque.peek().right != null){
                arrayDeque.add(arrayDeque.peekFirst().right);
                nextLevel++;
            }

//            System.out.print(arrayDeque.peekFirst().val +" ");
            listInner.add(arrayDeque.peekFirst().val);
            arrayDeque.removeFirst();
            curLevel--;

        }
        list.add(listInner);

        return list;

    }

    public static List<List<Integer>> levelOrder_03(TreeNode32 root){
        List<List<Integer> > list = new ArrayList<>();

        if(root == null){
            return list;
        }

        List<Integer> listInner = new ArrayList<>();

        Stack<TreeNode32> stack1 = new Stack<>(); // 奇数层
        Stack<TreeNode32> stack2 = new Stack<>(); // 偶数层

        stack1.push(root);
        int curLevel = 1;
        int nextLevel =0;

        int level = 1;

        while(!stack1.isEmpty() || !stack2.isEmpty() ){

            if(curLevel == 0){
                curLevel = nextLevel;
                nextLevel = 0;
                level++; // level没想明白
                list.add(listInner);
                listInner = new ArrayList<>();;
                System.out.println("-------");
            }



            if(level%2 == 0){
                if(stack2.peek().right != null){
                    stack1.push(stack2.peek().right);
                    nextLevel++;
                }
                if(stack2.peek().left != null){
                    stack1.push(stack2.peek().left);
                    nextLevel++;
                }


                System.out.println(stack2.peek().val);
                listInner.add(stack2.peek().val);
                stack2.pop();
                curLevel--;

            }else{
                if(stack1.peek().left != null){
                    stack2.push(stack1.peek().left);
                    nextLevel++;
                }
                if(stack1.peek().right != null){
                    stack2.push(stack1.peek().right);
                    nextLevel++;
                }


                System.out.println(stack1.peek().val);
                listInner.add(stack1.peek().val);
                stack1.pop();
                curLevel--;
            }




        }

        list.add(listInner);

        System.out.println("--------------------------");

        return list;

    }

}
