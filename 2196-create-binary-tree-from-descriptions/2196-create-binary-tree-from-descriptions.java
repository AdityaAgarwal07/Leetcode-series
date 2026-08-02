class Solution {
    public TreeNode createBinaryTree(int[][] arr) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> child = new HashSet<>();
        for (int[] nums : arr) {
            int a = nums[0];
            int b = nums[1];
            int c = nums[2];
            TreeNode node = map.computeIfAbsent(a, k -> new TreeNode(k));
            TreeNode aa = map.computeIfAbsent(b, k -> new TreeNode(k));
            child.add(b);
            if (c == 0) node.right = aa;
            else node.left = aa;
        }
        for (int val : map.keySet()) {
            if (!child.contains(val)) return map.get(val);
        }
        return null;
    }
}