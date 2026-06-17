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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode a: lists){
            while(a!=null){
                pq.offer(a);
                a=a.next;
            }
        }
        if(pq.isEmpty()) return null;
        ListNode head = pq.poll();
        ListNode temp = head;
        while(!pq.isEmpty()){
            temp.next = pq.poll();
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

   
}