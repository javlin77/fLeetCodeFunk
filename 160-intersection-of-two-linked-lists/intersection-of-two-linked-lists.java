/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0;
        int l2 = 0;
        ListNode n1 = headA;
        ListNode n2 = headB;
        while (n1 != null) {
            l1++;
            n1 = n1.next;
        }
        while (n2 != null) {
            l2++;
            n2 = n2.next;
        }
        n1 = headA;
        n2 = headB;
        if (l1 > l2) {
            int diff = l1 - l2;
            while (diff-- > 0){
                n1 = n1.next;
            }
        } else {
            int diff = l2 - l1;
            while (diff-- > 0){
                n2 = n2.next;
            }
        }
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n2;
    }
}