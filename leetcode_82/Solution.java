

import java.net.InetAddress;
import java.util.HashSet;

public class Solution {


    public static class ListNode82 {
        int val;
        ListNode82 next;
        ListNode82() {}
        ListNode82(int val) { this.val = val; }
        ListNode82(int val, ListNode82 next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

//        1->1->2->3->3
        ListNode82 head = new ListNode82(1);

        deleteDuplicates(head);
        deleteDuplicates_Leetcode(head);
    }

    public static ListNode82 deleteDuplicates_Leetcode(ListNode82 head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode82 next = head.next;

        if(head.val == next.val){

            while(next != null && next.val == head.val){
                next = next.next;
            }

            head = deleteDuplicates_Leetcode(head);


        }else {
            head.next = deleteDuplicates_Leetcode(next);
        }

        return head;


    }




    public static ListNode82 deleteDuplicates(ListNode82 head) {


        if(head == null || head.next == null){
            return head;
        }

        ListNode82 cur = head;
        ListNode82 next = head.next;
        ListNode82 pre = cur;

        while(cur != null && next != null){

            int val = cur.val;

            int count = 0;
            while(next != null && next.val == val){
                next = next.next;
                count++;
            }



            if(cur == head && count > 0){
                head = next;
                cur = head;
                pre = cur;
                if(cur != null){
                    next = cur.next;
                }

                continue;
            }

            if(count == 0){
                if(head != cur){
                    pre = pre.next;
                }
                cur = next;
                next = next.next;


                continue;

            }

            if(count > 0){

                pre.next = next;
                cur = next;
                if(next != null){
                    next = next.next;
                }

                continue;


            }






        }


        return head;







    }


}
