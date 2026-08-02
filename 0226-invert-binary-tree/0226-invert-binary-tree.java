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
    public TreeNode invertTree(TreeNode root) {
        return find(root);
    }
    private TreeNode find(TreeNode node){
        if(node == null) return null;
        TreeNode aa = find(node.left);
        node.left = find(node.right);
        node.right = aa;
        return node;
    }
}