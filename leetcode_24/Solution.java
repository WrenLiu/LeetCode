/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        return swap( head);
    }
    //一共三个节点:head, next, swapPairs(next.next)
    //下面的任务便是交换这3个节点中的前两个节点
    private ListNode swap(ListNode node){
        if(node == null || node.next == null){
            return node;
        }

        ListNode tmp = node.next;
        node.next = swap(tmp.next);
        tmp.next = node;

        return tmp;

    }
}