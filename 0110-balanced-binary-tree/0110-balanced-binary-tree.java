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
    boolean ans;
    public boolean isBalanced(TreeNode root) {
        ans = true;
        find(root);
        return ans;
    }
    private int find(TreeNode node){
        if(!ans) return 0;
        if(node == null) return 0;
        int a = find(node.left);
        int b = find(node.right);
        if(Math.abs(a - b) > 1) ans = false;
        return 1 + Math.max(a, b);
    }
}