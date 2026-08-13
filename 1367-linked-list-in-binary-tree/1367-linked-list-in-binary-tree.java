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
    public boolean isSubPath(ListNode head, TreeNode node) {
        if(head == null) return true;
        if(node == null) return false;
        boolean aa = false;
        if(head.val == node.val) aa = find(head, node);
        if(aa) return true;
        return isSubPath(head, node.left) || isSubPath(head, node.right);
    }
    private boolean find(ListNode head, TreeNode node){
        if(head == null) return true;
        if(node == null || head.val != node.val) return false;
        return find(head.next, node.left) || find(head.next, node.right);
    }
}