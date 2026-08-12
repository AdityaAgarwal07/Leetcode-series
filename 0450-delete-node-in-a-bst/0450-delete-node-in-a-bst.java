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
    public TreeNode deleteNode(TreeNode node, int val) {
        if(node == null) return node;
        if(node.val == val){
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
        node.left = deleteNode(node.left, val);
        node.right = deleteNode(node.right, val);
        return node;
    }
}