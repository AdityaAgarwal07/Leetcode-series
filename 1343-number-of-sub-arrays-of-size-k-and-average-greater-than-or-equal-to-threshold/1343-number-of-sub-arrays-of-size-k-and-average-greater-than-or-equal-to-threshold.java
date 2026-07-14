class Solution {
    public int numOfSubarrays(int[] nums, int k, int x) {
        int ans = 0, curr = 0, j = 0, n = nums.length;
        while(j < n && j < k) curr += nums[j++];
        j = 0;
        if(curr / k >= x) ans++;
        if(j == n) return ans;
        for(int i = k; i < n; i++){
            curr -= nums[j++];
            curr += nums[i];
            if(curr / k >= x) ans++;
        }
        return ans;
    }
}