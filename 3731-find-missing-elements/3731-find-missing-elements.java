class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int a = nums[0];
        int b = nums[0];
        for(int n : nums){
            a = Math.max(a, n);
            b = Math.min(b, n);
        }
        int[] arr = new int[a + 1];
        for(int n : nums) arr[n]++;
        List<Integer> ans = new ArrayList<>();
        for(int i = b; i < a; i++){
            if(arr[i] == 0) ans.add(i);
        }
        return ans;
    }
}