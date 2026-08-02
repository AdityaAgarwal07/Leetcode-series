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
    public boolean leafSimilar(TreeNode r1, TreeNode r2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        find(r1, l1);
        find(r2, l2);
        return l1.equals(l2);
    }
    private void find(TreeNode node, List<Integer> n1){
        if(node == null) return;
        if(node.left == null && node.right == null){
            n1.add(node.val);
            return;
        }
        find(node.left, n1);
        find(node.right, n1);
    }
}