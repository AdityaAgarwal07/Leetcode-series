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
    public String tree2str(TreeNode node) {
        if(node == null) return "";
        if(node.left == null && node.right == null) return node.val + "";
        String aa = "(" + tree2str(node.left) + ")";
        String bb = (node.right != null) ? "(" + tree2str(node.right) + ")" : "";
        return node.val + aa + bb;
    }
}