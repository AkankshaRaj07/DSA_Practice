/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next !=null){
            fast= fast.next.next;
            slow= slow.next;
        }
        ListNode node= rev(slow.next);
        ListNode temp= head;
        while(node != null){
            if(node.val != temp.val) return false;
            temp=temp.next;
            node=node.next;
        }
        return true;

    }
    public ListNode rev(ListNode head){
        if(head== null || head.next== null) return head;
        ListNode newHead = rev(head.next);
        ListNode front= head.next;
        front.next= head;
        head.next = null;
        return newHead;
    }

}