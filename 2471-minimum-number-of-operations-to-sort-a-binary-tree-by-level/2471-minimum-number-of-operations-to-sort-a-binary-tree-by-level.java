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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int ans = 0;
        while(!q.isEmpty()){
            int n = q.size();
            int i = 0;
            int[][] nums = new int[n][2];
            while(n --> 0){
                TreeNode node = q.poll();
                nums[i][0] = node.val;
                nums[i][1] = i;
                i++;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            ans += find(nums);
        }
        return ans;
    }
    private int find(int[][] nums){
        int n = nums.length;
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        boolean[] val = new boolean[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(val[i] || nums[i][1] == i) continue;
            int j = i;
            int curr = 0;
            while(!val[j]){
                val[j] = true;
                curr++;
                j = nums[j][1];
            }
            ans += curr - 1;
        }
        return ans;
    }
}