class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        char opr = '+';
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(c == ' '){
                i++;
                continue;
            }else if(Character.isDigit(c)){
                int n = 0;
                while(i < s.length() && Character.isDigit(c)){
                    n = n * 10 + Integer.parseInt(c + "");
                    i++;
                    if(i < s.length()) c = s.charAt(i);
                }
                if(opr == '+'){
                    st.push(n);
                }else if(opr == '-'){
                    st.push(-n);
                }else if(opr == '*'){
                    st.push(n * st.pop());
                }else{
                    st.push(st.pop() / n);
                }
            }else{
                opr = c;
                i++;
            }
        }
        while(!st.isEmpty()) ans += st.pop();
        return ans;
    }
}