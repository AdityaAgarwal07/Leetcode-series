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
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        find(root, 0);
        return ans;
    }
    private void find(TreeNode node, int curr){
        if(node == null) return;
        curr *= 10;
        curr += node.val;
        if(node.left == null && node.right == null) ans += curr;
        find(node.left, curr);
        find(node.right, curr);
    }
}