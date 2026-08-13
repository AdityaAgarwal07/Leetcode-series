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
    int n;
    int aa = -1;
    public int findBottomLeftValue(TreeNode root) {
        find(root, 0);
        return n;
    }
    private void find(TreeNode node, int a){
        if(node == null) return;
        if(node.left == null && node.right == null){
            if(a > aa){
                aa = a;
                n = node.val;
            }
        }
        find(node.left, a + 1);
        find(node.right, a + 1);
    }
}