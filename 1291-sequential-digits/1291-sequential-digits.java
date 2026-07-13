class Solution {
    public List<Integer> sequentialDigits(int l, int h) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i < 9; i++){
            int x = i;
            for(int j = i + 1; j < 10; j++){
                x = x * 10 + j;
                if(x >= l && x <= h) ans.add(x);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}