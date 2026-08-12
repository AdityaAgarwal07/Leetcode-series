/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode a, TreeNode b) {
        if(node == null) return node;
        if(node == a || node == b) return node;
        TreeNode l = lowestCommonAncestor(node.left, a, b);
        TreeNode r = lowestCommonAncestor(node.right, a, b);
        if(l != null && r != null) return node;
        return l == null ? r : l;
    }
}