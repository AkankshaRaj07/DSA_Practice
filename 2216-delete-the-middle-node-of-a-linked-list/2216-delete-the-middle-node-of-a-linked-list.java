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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null) return head;
        if(head.next == null) return null;
        if(head.next.next== null){
            head.next= null;
            return head;
        }
        ListNode fast= head;
        ListNode slow= head;
        while(fast != null && fast.next != null){
            fast=fast.next.next;
            slow=slow.next;
        }
        while(slow.next!= null){
            slow.val=slow.next.val;
            slow=slow.next;
        }
        ListNode he= head;
        while(he.next.next!=null){
            he=he.next;
        }
        he.next=null;
        return head;
    }
}