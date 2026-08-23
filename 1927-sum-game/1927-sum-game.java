class Solution {
    public boolean sumGame(String s) {
        int n = s.length();
        int a = 0;
        int b = 0;
        int s1 = 0;
        int s2 = 0;
        for(int i = 0; i < n / 2; i++){
            if(s.charAt(i) == '?'){
                a++;
                continue;
            }
            s1 += s.charAt(i) - '0';
        }
        for(int i = n / 2; i < n; i++){
            if(s.charAt(i) == '?'){
                b++;
                continue;
            }
            s2 += s.charAt(i) - '0';
        }
        return find(a, b, s1, s2);
    }
    private boolean find(int a, int b, int s1, int s2){
        if((a + b) % 2 == 1){
            return true;
        }
        int diff = s1 - s2;
        if(a > b){
            diff += 9 * ((a - b) / 2);
        } 
        else {
            diff -= 9 * ((b - a) / 2);
        }
        return diff != 0;
    }
}