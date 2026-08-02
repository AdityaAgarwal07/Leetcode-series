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
    public boolean evaluateTree(TreeNode node) {
        if(node.left == null && node.right == null) return (node.val == 0) ? false : true;
        if(node.val == 2) return evaluateTree(node.left) || evaluateTree(node.right);
        return evaluateTree(node.left) && evaluateTree(node.right);
    }
}