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
    public TreeNode sortedArrayToBST(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }
    private TreeNode find(int[] nums, int i, int j){
        if(i > j) return null;
        int m = i + (j - i) / 2;
        TreeNode node = new TreeNode(nums[m], find(nums, i, m - 1), find(nums, m + 1, j));
        return node;
    }
}