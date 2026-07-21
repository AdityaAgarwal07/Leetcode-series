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
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode node) {
        ans = new ArrayList<>();
        if(node == null) return ans;
        if(node.left == null && node.right == null){
            ans.add(node.val + "");
            return ans;
        }
        if(node.left != null) find(node.left, node.val + "");
        if(node.right != null) find(node.right, node.val + "");
        return ans;
    }
    private void find(TreeNode node, String s){
        if(node.left == null && node.right == null){
            ans.add(s + "->" + node.val);
            return;
        }
        if(node.left != null) find(node.left, s + "->" + node.val);
        if(node.right != null) find(node.right, s + "->" + node.val);
    }
}