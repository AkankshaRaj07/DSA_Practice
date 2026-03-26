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
class Solution{
    public ListNode sortList(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode mid=getMid(head);
        ListNode right=mid.next;
        mid.next=null;
        ListNode leftSorted=sortList(head);
        ListNode rightSorted=sortList(right);
        return merge(leftSorted,rightSorted);
    }
    ListNode getMid(ListNode head){
        ListNode slow=head,fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    ListNode merge(ListNode a,ListNode b){
        ListNode dummy=new ListNode(-1),temp=dummy;
        while(a!=null&&b!=null){
            if(a.val<b.val){
                temp.next=a;
                a=a.next;
            }else{
                temp.next=b;
                b=b.next;
            }
            temp=temp.next;
        }
        if(a!=null)temp.next=a;
        if(b!=null)temp.next=b;
        return dummy.next;
    }
}