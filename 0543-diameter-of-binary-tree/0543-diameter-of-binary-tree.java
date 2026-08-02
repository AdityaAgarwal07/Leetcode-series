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
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        aa(root);
        return ans;
    }
    private int find(TreeNode node){
        if(node == null) return 0;
        return 1 + Math.max(find(node.left), find(node.right));
    }
    private void aa(TreeNode node){
        if(node == null) return;
        ans = Math.max(ans, find(node.left) + find(node.right));
        aa(node.left);
        aa(node.right);
    }
}