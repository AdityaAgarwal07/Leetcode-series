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
    public boolean isSubtree(TreeNode root, TreeNode a) {
        if(root == null) return false;
        if(root.val == a.val && find(root, a)) return true;
        return isSubtree(root.left, a) || isSubtree(root.right, a);
    }
    private boolean find(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val) return false;
        return find(p.left, q.left) && find(p.right, q.right);
    }
}