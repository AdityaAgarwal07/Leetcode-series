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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            while(n --> 0){
                TreeNode node = q.poll();
                if(node != null){
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            List<TreeNode> aa = new ArrayList<>(q);
            if(!find(aa)) return false;
        }
        return true;
    }
    private boolean find(List<TreeNode> nums){
        int i = 0;
        int j = nums.size() - 1;
        while(i < j){
            TreeNode a = nums.get(i);
            TreeNode b = nums.get(j);
            if(a == null && b == null){
                i++;
                j--;
                continue;
            }
            if(a == null || b == null || a.val != b.val) return false;
            i++;
            j--;
        }
        return true;
    }
}