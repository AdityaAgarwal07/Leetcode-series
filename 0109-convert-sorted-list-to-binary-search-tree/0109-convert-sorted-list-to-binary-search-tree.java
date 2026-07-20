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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return find(head);
    }
    private TreeNode find(ListNode node){
        if(node == null) return null;
        if(node.next == null) return new TreeNode(node.val);
        ListNode s = node, f = node, p = null;
        while(f != null && f.next != null){
            p = s;
            s = s.next;
            f = f.next.next;
        }
        TreeNode ans = new TreeNode(s.val);
        p.next = null;
        ans.left = find(node);
        ans.right = find(s.next);
        return ans;
    }
}