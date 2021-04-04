package WebTest.Offer.chap03;

import java.util.HashMap;
import java.util.LinkedList;

public class Offer24 {

    public static class ListNode24 {
        int val;
        ListNode24 next;
        ListNode24(int x) { val = x; }
    }


    public static void main(String[] args) {
        ListNode24 head = new ListNode24(1);
        head.next = new ListNode24(2);
        head.next.next = new ListNode24(3);
        head.next.next.next = new ListNode24(4);
        head.next.next.next.next = new ListNode24(5);
        head.next.next.next.next.next = new ListNode24(6);

        ListNode24 tmp = reverseList(head);

        while(tmp != null){

            System.out.println(tmp.val);
            tmp = tmp.next;

        }
        System.out.println("Hello");


    }

    public static ListNode24 reverseList_Book(ListNode24 head){

        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode24 listNodePre = head;
        ListNode24 listNodeCur = head.next;
        ListNode24 listNodeNext = listNodeCur.next;

        head.next = null;
        listNodeCur.next = listNodePre;



        while(listNodeNext != null){

            listNodeCur.next = listNodePre;
            listNodePre = listNodeCur;
            listNodeCur = listNodeNext;
            listNodeNext = listNodeNext.next;
        }

        listNodeCur.next = listNodePre;

        return listNodeCur;

    }


    public static ListNode24 reverseList(ListNode24 head) {

        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        HashMap<Integer,ListNode24> hashMap = new HashMap<>();

        ListNode24 listNode23 = head;

        int length = 0;

        while(listNode23.next != null){
            hashMap.put(length,listNode23);
            length++;
            listNode23 = listNode23.next;

        }

        hashMap.put(length,listNode23);


        ListNode24 listnode_NewHead = new ListNode24(hashMap.get(length).val);

        ListNode24 listnodePoint = new ListNode24(hashMap.get(length-1).val);

        listnode_NewHead.next = listnodePoint;

        for (int i = length-2; i >= 0; i--) {

            ListNode24 tmp = new ListNode24(hashMap.get(i).val);

            listnodePoint.next = tmp;
            listnodePoint = tmp;

        }

        return listnode_NewHead;

    }

}
