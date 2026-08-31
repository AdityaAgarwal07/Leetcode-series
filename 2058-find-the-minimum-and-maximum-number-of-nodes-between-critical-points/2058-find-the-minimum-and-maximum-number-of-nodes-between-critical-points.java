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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return new int[]{-1, -1};
        ArrayList<Integer> ls = new ArrayList<>();
        ListNode temp = head.next;
        ListNode prev = head;
        int a = 1;
        while(temp.next != null){
            if(check(temp, prev)) ls.add(a);
            temp = temp.next;
            prev = prev.next;
            a++;
        }
        if(ls.size() < 2) return new int[]{-1, -1};
        int bb = ls.get(ls.size() - 1) - ls.get(0);
        int aa = bb;
        for(int i = 1; i < ls.size(); i++){
            aa = Math.min(aa, ls.get(i) - ls.get(i - 1));
        }
        return new int[]{aa, bb};
    }
    static boolean check(ListNode a, ListNode b){
        if(a.val > b.val && a.val > a.next.val) return true;
        if(a.val < b.val && a.val < a.next.val) return true;
        return false;
    }
}