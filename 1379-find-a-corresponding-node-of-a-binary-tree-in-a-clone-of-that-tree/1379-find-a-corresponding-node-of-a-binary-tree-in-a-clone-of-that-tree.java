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
    public final TreeNode getTargetCopy(final TreeNode a, final TreeNode b, final TreeNode t) {
        return find(a, b, t);
    }
    private TreeNode find(TreeNode a, TreeNode b, TreeNode t){
        if(a == t) return b;
        TreeNode aa = (a.left != null) ? find(a.left, b.left, t) : null;
        TreeNode bb = (a.right != null) ? find(a.right, b. right, t) : null;
        return (aa == null) ? bb : aa;
    }
}