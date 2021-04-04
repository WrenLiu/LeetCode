/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Node resultHeadNode = new Node(head.val);

        if(head.next == null){
            int index = indexFind(head,head.random);
            if(index==-1){
                return resultHeadNode;
            }else if(index == 0) {
                resultHeadNode.random = resultHeadNode;
            }

            return resultHeadNode;
        }

        Node nodeOriginP = head;
        Node resultNodeP = resultHeadNode;
        HashMap<Node,Integer> hashMap = new HashMap<>();
        hashMap.put(resultHeadNode,indexFind(head,nodeOriginP.random));

        while(nodeOriginP.next != null){

            resultNodeP.next = new Node(nodeOriginP.next.val);
            resultNodeP = resultNodeP.next;
            nodeOriginP = nodeOriginP.next;

            hashMap.put(resultNodeP,indexFind(head,nodeOriginP.random));
        }

        resultNodeP = resultHeadNode;
        nodeOriginP = head;

        Node nodeOuterPointer = resultNodeP;
        while(nodeOuterPointer != null){

            int index = hashMap.get(nodeOuterPointer);
            if(index==-1){
                nodeOuterPointer = nodeOuterPointer.next;
                continue;
            }

            Node nodeTmpPointer = resultHeadNode;

            for (int i = 0; i < index; i++) {
                nodeTmpPointer = nodeTmpPointer.next;
            }

            nodeOuterPointer.random = nodeTmpPointer;
            nodeOuterPointer = nodeOuterPointer.next;

        }



        return resultHeadNode;


    }

    private static int indexFind(Node head,Node nodeFind){

        if(nodeFind == null){
            return -1;
        }

        int index = 0;
        Node tmp = head;
        while(tmp != null){
            if(tmp == nodeFind){
                break;
            }
            tmp = tmp.next;
            ++index;
        }
        return index;

    }
}