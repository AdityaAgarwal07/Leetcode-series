class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        find(root);
        return ans;
    }
    private int find(TreeNode node) {
        if (node == null) return 0;
        int left = find(node.left);
        int right = find(node.right);
        ans = Math.max(ans, left + right);
        return 1 + Math.max(left, right);
    }
}