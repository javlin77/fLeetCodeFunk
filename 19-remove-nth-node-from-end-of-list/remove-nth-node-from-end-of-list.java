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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        int len=0;
        ListNode c=head;
        while(c!=null){
            len++;
            c=c.next;
        }
        int pos=len-n+1;
        if(pos==1){
            return head.next;
        }
        ListNode curr=head;
        for(int i=1;i<pos-1;i++){
            curr=curr.next;
        }
        curr.next=curr.next.next;
        return head;
    }
}