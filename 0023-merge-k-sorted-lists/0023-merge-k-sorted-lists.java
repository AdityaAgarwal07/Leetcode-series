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
        return find(nums, 0, nums.length - 1);
    }
    private ListNode find(ListNode[] nums, int i, int j){
        if(i == j) return nums[i];
        int mid = i + (j - i) / 2;
        return merge(find(nums, i, mid), find(nums, mid + 1, j));
    }
    private ListNode merge(ListNode l1, ListNode l2){
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
        ans.next = (l1 == null) ? l2 : l1;
        return val.next;
    }
}