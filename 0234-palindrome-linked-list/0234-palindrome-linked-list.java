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
        ListNode prev = null;
        ListNode s = head;
        ListNode f = head;
        while(f != null && f.next != null){
            prev = s;
            s = s.next;
            f = f.next.next;
        }
        prev.next = null;
        ListNode aa = null;
        while(s != null){
            ListNode node = s.next;
            s.next = aa;
            aa = s;
            s = node;
        }
        while(aa != null && head != null){
            if(head.val != aa.val) return false;
            head = head.next;
            aa = aa.next;
        }
        return true;
    }
}