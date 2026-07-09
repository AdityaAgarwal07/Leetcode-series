class Solution {
    public String minWindow(String s, String t) {
        int[] n1 = new int[128];
        for(char c : t.toCharArray()) n1[c]++;
        int i = 0, j = 0;
        int ans = Integer.MAX_VALUE;
        String ss = null;
        while(j < s.length()){
            n1[s.charAt(j++)]--;
            while(aa(n1)){
                if(j - i < ans){
                    ans = j - i;
                    ss = s.substring(i, j);
                }
                n1[s.charAt(i++)]++;
            }
        }
        return (ss != null) ? ss : "";
    }
    private boolean aa(int[] n1){
        for(int n : n1) if(n > 0) return false;
        return true;
    }
}