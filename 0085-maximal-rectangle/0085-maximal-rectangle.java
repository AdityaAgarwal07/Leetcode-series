class Solution {
    int m;
    public int maximalRectangle(char[][] nums) {
        m = nums[0].length;
        int[] arr = new int[m];
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < m; j++){
                if(nums[i][j] == '1') arr[j]++;
                else arr[j] = 0;
            }
            ans = Math.max(ans, find(arr));
        }
        return ans;
    }
    private int find(int[] heights){
        int res = 0, n = heights.length;
        Deque<Integer> stk = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < n; ++i) {
            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) {
                right[stk.pop()] = i;
            }
            left[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }
        for (int i = 0; i < n; ++i) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
}