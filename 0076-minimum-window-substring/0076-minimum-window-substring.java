class Solution {
    public String minWindow(String s, String t) {
        int[] n1 = new int[128];
        for(char c : t.toCharArray()) n1[c]++;
        int i = 0, j = 0;
        int ans = Integer.MAX_VALUE;
        String ss = null;
        int nn = t.length();
        while(j < s.length()){
            if(n1[s.charAt(j++)]-- > 0) nn--;
            while(nn == 0){
                if(j - i < ans){
                    ans = j - i;
                    ss = s.substring(i, j);
                }
                if(++n1[s.charAt(i++)] > 0){
                    nn++;
                }
            }
        }
        return (ss != null) ? ss : "";
    }
}