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
    long sum = 0;
    long ans = 0;
    int mod = 1000000007;
    public int maxProduct(TreeNode root) {
        if(root == null) return 0;
        aa(root);
        find(root);
        return (int)(ans % mod);
    }
    public void aa(TreeNode node){
        if(node == null) return;
        aa(node.left);
        aa(node.right);
        sum += node.val;
    }
    public long find(TreeNode node){
        if(node == null) return 0;
        long l = find(node.left);
        long r = find(node.right);
        long a = Math.max((sum - l) * l, (sum - r) * r);
        ans = Math.max(ans, a);
        return node.val + l + r;
    }
}