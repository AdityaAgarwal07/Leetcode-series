class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = nums[i] + "";
        }
        Arrays.sort(arr, (a, b) -> {
            return ((b + a).compareTo(a + b));
        });
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < n; i++) ans.append(arr[i]);
        String ss = ans.toString();
        return (ss.startsWith("0") ? "0" : ss);
    }
}