public class Solution {

    public static class ListNode61 {
        int val;
        ListNode61 next;
        ListNode61() {}
        ListNode61(int val) { this.val = val; }
        ListNode61(int val, ListNode61 next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {

        ListNode61 head = new ListNode61(0);
        ListNode61 node01 = new ListNode61(1);
        ListNode61 node02 = new ListNode61(2);
        head.next = node01 ;
        node01.next = node02;

        ListNode61 tmp = rotateRight(head,4);
        System.out.println(tmp.val);
    }

    public static ListNode61 rotateRight(ListNode61 head, int k) {

        if(head == null){
            return null;
        }

        ListNode61 cur = head;
        ListNode61 pre = head;

        int total = 1;

        while(cur.next != null){
            cur = cur.next;
            total++;
        }

        pre = cur;
        cur.next = head;
        cur = head;


        if(k < total){

            int count = total - k;
            for (int i = 0; i < count; i++) {
                cur = cur.next;
                pre = pre.next;
            }

            pre.next = null;
            return cur;


        }else{

            int count = total - k % total ;
            for (int i = 0; i < count; i++) {
                cur = cur.next;
                pre = pre.next;
            }
            pre.next = null;
            return cur;

        }


    }
}
