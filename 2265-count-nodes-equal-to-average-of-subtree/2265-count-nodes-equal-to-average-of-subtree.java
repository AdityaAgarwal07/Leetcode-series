class Solution {
    int ans;
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        find(root);
        return ans;
    }
    private int[] find(TreeNode node){
        if(node == null) return new int[]{0, 0};
        int[] a = find(node.left);
        int[] b = find(node.right);
        int val = a[0] + b[0] + node.val;
        int aa = a[1] + b[1] + 1;
        if(val / aa == node.val) ans++;
        return new int[]{val, aa};
    }
}