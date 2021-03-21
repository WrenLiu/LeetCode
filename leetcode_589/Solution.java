import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    class Node589 {
        public int val;
        public List<Node589> children;

        public Node589() {}

        public Node589(int _val) {
            val = _val;
        }

        public Node589(int _val, List<Node589> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<Integer> preorder(Node589 root) {

        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> arrayList = new ArrayList<>();


        helper(root,arrayList);
        return arrayList;

    }

    private static void helper(Node589 root , ArrayList<Integer> arrayList){

        if(root == null){
            return;
        }


        arrayList.add(root.val);

        List<Node589> list = root.children;

        for (Node589 node589 : list) {
            helper(node589,arrayList);
        }




    }

    public List<Integer> preorder_Stack(Node589 root) {

        if(root == null){
            return new ArrayList<>();
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Node589> stack = new Stack<>();

        List<Node589> listTmp;

        stack.push(root);

        while(!stack.isEmpty()){

            Node589 tmp = stack.pop();

            arrayList.add(tmp.val);

            listTmp = tmp.children;



            for (int i = listTmp.size()-1; i >= 0 ; i--) {
                stack.add(listTmp.get(i));
            }







        }


        return arrayList;

    }

}
