

import java.util.HashSet;

public class Solution {

    public static class ListNode83 {
        int val;
        ListNode83 next;
        ListNode83() {}
        ListNode83(int val) { this.val = val; }
        ListNode83(int val, ListNode83 next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

//        1->1->2->3->3
        ListNode83 head = new ListNode83(1);

        deleteDuplicates(head);
    }

    public static ListNode83 deleteDuplicates_Leetcode(ListNode83 head){

        if(head == null || head.next == null){
            return head;
        }

        head.next = deleteDuplicates_Leetcode(head.next);

        if(head.val == head.next.val){
            head = head.next;
        }

        return head;

    }

    public static ListNode83 deleteDuplicates(ListNode83 head) {


        if(head == null || head.next == null){
            return head;
        }

        HashSet<Integer> hashSet = new HashSet<>();

        ListNode83 pre = head;
        ListNode83 cur = head.next;

        hashSet.add(pre.val);


        while(cur != null){

            if(hashSet.contains(cur.val)){
                pre.next = cur.next;
                cur = pre.next;
            }else {
                hashSet.add(cur.val);
                pre = cur;
                cur = cur.next;
            }

        }

        return head;





    }


}
