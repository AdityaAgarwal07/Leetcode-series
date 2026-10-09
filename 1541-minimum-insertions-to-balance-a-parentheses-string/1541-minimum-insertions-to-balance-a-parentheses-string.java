class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                count += 2;
                if(count % 2 != 0){
                    count--;
                    ans++;
                }
            }else{
                count--;
                if(count < 0){
                    count = 1;
                    ans++;
                }
            }
        }
        return ans + count;
    }
}