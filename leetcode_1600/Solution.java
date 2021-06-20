import java.util.*;

public class Solution {


    // N叉树的遍历
    static class ThroneInheritance {

        class Node1600{

            String name;
            boolean isAlive;
            List<Node1600> childNodes;
            Node1600(String _name){
                name = _name;
                childNodes = new ArrayList<>();
                isAlive = true;
            }
        }

        private static Node1600 kingNode;

        private static HashMap<String , Node1600> map = new HashMap<>();


        public ThroneInheritance(String kingName) {

            kingNode = new Node1600(kingName);
            map.put(kingName , kingNode);

        }

        public void birth(String parentName, String childName) {


            Node1600 node = new Node1600(childName);
            map.put(childName , node);

            Node1600 parentNode = map.get(parentName);
            parentNode.childNodes.add(node);

        }

        public void death(String name) {

            map.get(name).isAlive = false;

        }

        public List<String> getInheritanceOrder() {

            List<String> res = new ArrayList<>();

            preOrder(kingNode , res);

            return res;

        }

        // 中序遍历
        private static void preOrder(Node1600 root , List<String> list){
            if(root == null) return ;

            List<Node1600> childNode = root.childNodes;
            if(root.isAlive){
                list.add(root.name);
            }

            for (int i = 0; i < childNode.size() ;  i++) {
                preOrder( childNode.get(i)  ,list);
            }

        }

    }


    public static void main(String[] args) {

        ThroneInheritance t= new ThroneInheritance("king");
        t.birth("king", "andy"); // 继承顺序：king > andy
        t.birth("king", "bob"); // 继承顺序：king > andy > bob
        t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
        t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
        t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
        t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
        List<String> list  = t.getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        for (String string : list) {
            System.out.print(string+" ");
        }
        System.out.println();



        t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
        list = t.getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]
        for (String string : list) {
            System.out.print(string+" ");
        }
        System.out.println();
    }



}
