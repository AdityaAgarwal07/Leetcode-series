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
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int n = q.size();
            ans = new ArrayList<>();
            while(n --> 0){
                TreeNode node = q.poll();
                ans.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }
        return ans.get(0);
    }
}