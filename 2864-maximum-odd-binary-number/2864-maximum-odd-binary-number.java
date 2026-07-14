class Solution {
    public String maximumOddBinaryNumber(String s) {
        int o = 0, n = s.length();
        for(char c : s.toCharArray()) if(c == '1') o++;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i++ < o - 1) sb.append("1");
        while(i++ <= n - 1) sb.append("0");
        sb.append("1");
        return sb.toString();
    }
}