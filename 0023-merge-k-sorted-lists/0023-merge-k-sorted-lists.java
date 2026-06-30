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
    public ListNode mergeKLists(ListNode[] nums) {
        if(nums.length == 0) return null;
        ListNode l1 = nums[0];
        for(int i = 1; i < nums.length; i++){
            l1 = find(l1, nums[i]);
        }
        return l1;
    }
    private ListNode find(ListNode l1, ListNode l2){
        ListNode ans = new ListNode();
        ListNode val = ans;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                ans.next = l1;
                l1 = l1.next;
            }else{
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;
        }
        if(l1 != null) ans.next = l1;
        if(l2 != null) ans.next = l2;
        return val.next;
    }
}