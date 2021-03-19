

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        ListNode92 head = new ListNode92(1);
        ListNode92 node1 = new ListNode92(2);
        ListNode92 node2 = new ListNode92(3);
        ListNode92 node3 = new ListNode92(4);
        ListNode92 node4 = new ListNode92(5);
        head.next = node1;node1.next = node2;node2.next = node3;node3.next = node4;

        ListNode92 headTmp = reverseBetween(head,1,5);

        while(headTmp != null){
            System.out.print(headTmp.val +" ");
            headTmp = headTmp.next;
        }

    }

    public static ListNode92 reverseBetween(ListNode92 head, int left, int right) {


        if(right == left || head == null ){
            return head;
        }

        int[] nums = new int[right-left+1];
        int indexNum = 0;

        ListNode92 pointer = head ;
        ListNode92 leftNode = head ;
        ListNode92 rightNode = head;

        int i = 0;
        for (; i < left-1 && pointer.next != null; i++) {
            pointer = pointer.next;
        }

        leftNode = pointer;

        for ( ; i < right && pointer != null; i++) {
            nums[indexNum++] = pointer.val;
            pointer = pointer.next;
        }

//        System.out.println(Arrays.toString(nums));
        rightNode = pointer;
        indexNum--;

        pointer = leftNode;
        while(pointer != rightNode){
            pointer.val = nums[indexNum--];
            pointer = pointer.next;
        }


        return head;


    }

    public static class ListNode92 {
        int val;
        ListNode92 next;
        ListNode92() {}
        ListNode92(int val) {
            this.val = val;
        }
        ListNode92(int val, ListNode92 next) {
            this.val = val;
            this.next = next;
        }

    }

}
