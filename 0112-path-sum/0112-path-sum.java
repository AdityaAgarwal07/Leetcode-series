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
    public boolean hasPathSum(TreeNode node, int t) {
        if(node == null) return false;
        if(node.left == null && node.right == null && t - node.val == 0) return true;
        return hasPathSum(node.left, t - node.val) || hasPathSum(node.right, t - node.val);
    }
}