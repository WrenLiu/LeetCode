
import java.util.HashMap;

public class Solution {

    public static class ListNode25 {
        int val;
        ListNode25 next;
        ListNode25(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode25 head01 = new ListNode25(1);
        head01.next = new ListNode25(2);
        head01.next.next = new ListNode25(4);

        ListNode25 head02 = new ListNode25(1);
        head02.next = new ListNode25(3);
        head02.next.next = new ListNode25(4);

        ListNode25 tmp = mergeTwoLists(head01,head02);

        while(tmp != null){

            System.out.println(tmp.val);
            tmp = tmp.next;

        }
        System.out.println("Hello");


    }

    public static ListNode25 mergeTwoLists_Book(ListNode25 l1, ListNode25 l2) {

        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }

        ListNode25 pMergeHead = null;

        if(l1.val < l2.val){
            pMergeHead = l1;
            pMergeHead.next = mergeTwoLists_Book(l1.next, l2);
        }else{
            pMergeHead = l2;
            pMergeHead.next = mergeTwoLists_Book(l1,l2.next);
        }

        return pMergeHead;

    }


    public static ListNode25 mergeTwoLists(ListNode25 l1 , ListNode25 l2){

        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }

        HashMap<Integer,ListNode25> hashmap = new HashMap<>();

        int count = 0;

        while(true){

            if(l1 == null){
                while(l2 != null){
                    hashmap.put(count++,l2);
                    l2 = l2.next;
                }

                break;

            }else if(l2 == null){
                while (l1 !=null){
                    hashmap.put(count++,l1);
                    l1 = l1.next;
                }

                break;

            }else {

                if(l1.val < l2.val){

                    hashmap.put(count++, l1);
                    l1 = l1.next;
                }else {

                    hashmap.put(count++, l2);
                    l2 = l2.next;
                }

            }

        }

        ListNode25 newListHead = hashmap.get(0);
        ListNode25 newPointer = hashmap.get(1);
        newListHead.next = newPointer;

        for (int i = 2; i < count; i++) {

            ListNode25 newTmp = hashmap.get(i);

            newPointer.next = newTmp;
            newPointer = newPointer.next;

        }

        return newListHead;
    }




}
