class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        find(n, 0, "");
        return ans;
    }
    public void find(int a, int b, String s){
        if(a == 0){
            if(b == 0){
                ans.add(s);
                return;
            }
            find(a, b - 1, s + ")");
        }else{
            if(b != 0) find(a, b - 1, s + ")");
            find(a - 1, b + 1, s + "(");
        }
    }
}