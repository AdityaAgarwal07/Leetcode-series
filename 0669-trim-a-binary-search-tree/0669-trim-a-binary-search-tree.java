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
    public TreeNode trimBST(TreeNode root, int l, int h) {
        if(root == null) return null;
        while(root != null && (l > root.val || root.val > h)) root = find(root);
        if(root == null) return root;
        root.left = trimBST(root.left, l, h);
        root.right = trimBST(root.right, l, h);
        return root;
    }
    private TreeNode find(TreeNode node){
        if(node == null) return null;
        if(node.left == null) return node.right;
        if(node.right == null) return node.left;
        TreeNode a = node.left;
        TreeNode aa = a;
        TreeNode b = node.right;
        TreeNode c = b.left;
        while(a.right != null) a = a.right;
        a.right = c;
        b.left = aa;
        return b;
    }
}