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
    int mod = (int) 1e9;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return find(root);
    }
    private int find(TreeNode node){
        if(node == null) return (int) 1e9;
        if(node.left == null && node.right == null) return 1;
        int n = find(node.left);
        int m = find(node.right);
        if(n == mod) return 1 + m;
        if(m == mod) return 1 + n;
        return 1 + Math.min(n , m);
    }
}