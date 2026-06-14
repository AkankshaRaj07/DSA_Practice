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
    public int pairSum(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp!= null){
            list.add(temp.val);
            temp= temp.next;
        }
        int n = list.size()-1;
        int sum = Integer.MIN_VALUE;
        for(int i = 0; i<=n/2; i++){
            sum = Math.max(sum, list.get(i)+ list.get(n-i));
        }

        return sum;
    }
}