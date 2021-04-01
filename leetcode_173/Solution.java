

import java.util.ArrayList;

public class Solution {

    static class TreeNode173 {
        int val;
        TreeNode173 left;
        TreeNode173 right;
        TreeNode173() {}
        TreeNode173(int val) { this.val = val; }
        TreeNode173(int val, TreeNode173 left, TreeNode173 right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class BSTIterator {

        ArrayList<Integer> arrayList ;
        int index ;

        public BSTIterator(TreeNode173 root) {
            arrayList = new ArrayList<>();
            index = 0;

            helper(arrayList,root);

            for (Integer integer : arrayList) {
                System.out.println(integer);
            }

        }

        private static void helper( ArrayList<Integer> arrayList , TreeNode173 root){
            if(root != null){

                helper(arrayList,root.left);
                arrayList.add(root.val);
                helper(arrayList,root.right);

            }

        }

        public int next() {

            return arrayList.get(index++);


        }

        public boolean hasNext() {


            return index < arrayList.size();

        }
    }
    public static void main(String[] args) {


        TreeNode173 root = new TreeNode173(7);
        TreeNode173 node01 = new TreeNode173(3);
        TreeNode173 node02 = new TreeNode173(15);
        TreeNode173 node03 = new TreeNode173(9);
        TreeNode173 node04 = new TreeNode173(20);

        root.left = node01;
        root.right = node02;
        node02.left = node03;
        node02.right = node04;

//        middle(root);



        BSTIterator bstIterator = new BSTIterator(root);

        System.out.println("---------------------------");
        while (bstIterator.hasNext()){
            System.out.print(bstIterator.next()+" ");
        }
        System.out.println();
        System.out.println("---------------------------");




    }

    private static void middle(TreeNode173 root){

        if(root != null){
            middle(root.left);
            System.out.println(root.val);

            middle(root.right);
        }

    }





}
