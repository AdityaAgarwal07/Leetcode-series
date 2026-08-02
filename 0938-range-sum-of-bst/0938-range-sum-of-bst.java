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
    public int rangeSumBST(TreeNode node, int l, int h) {
        if(node == null) return 0;
        int ans = (node.val >= l && node.val <= h) ? node.val : 0;
        return ans + rangeSumBST(node.left, l, h) + rangeSumBST(node.right, l, h);
    }
}