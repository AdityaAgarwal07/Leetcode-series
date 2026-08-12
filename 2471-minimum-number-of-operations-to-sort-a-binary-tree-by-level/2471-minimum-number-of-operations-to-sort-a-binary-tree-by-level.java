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
            List<Integer> nums = new ArrayList<>();
            while(n --> 0){
                TreeNode node = q.poll();
                nums.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            ans += find(nums);
        }
        return ans;
    }
    private int find(List<Integer> nums){
        int n = nums.size();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = nums.get(i);  
            arr[i][1] = i;            
        }
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
        boolean[] vis = new boolean[n];
            int swaps = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] || arr[i][1] == i) continue;
            int cycle = 0;
            int j = i;
            while(!vis[j]){
                vis[j] = true;
                j = arr[j][1];
                cycle++;
            }
            swaps += cycle - 1;
        }
        return swaps;
    }
}