class Solution {
    public int minMovesToSeat(int[] n1, int[] n2) {
        Arrays.sort(n1);
        Arrays.sort(n2);
        int ans = 0;
        for(int i = 0; i < n1.length; i++){
            ans += Math.abs(n1[i] - n2[i]);
        }
        return ans;
    }
}