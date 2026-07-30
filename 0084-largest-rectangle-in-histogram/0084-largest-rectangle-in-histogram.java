class Solution {
    public int largestRectangleArea(int[] nums) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int n = nums.length;
        int ans = nums[0];
        for(int i = 1; i < n; i++){
            while(!s.isEmpty() && nums[i] < nums[s.peek()]){
                int a = s.pop();
                int b = (s.isEmpty()) ? -1 : s.peek();
                ans = Math.max(ans, nums[a] * (i - b - 1));
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int a = s.pop();
            int b = (s.isEmpty()) ? -1 : s.peek();
            ans = Math.max(ans, nums[a] * (n - b - 1));
        }
        return ans;
    }
}