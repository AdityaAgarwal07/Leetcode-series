class Solution {
    public int calculate(String s) {
        Stack<Integer> ss = new Stack<>();
        int i = 0;
        char opr = '+';
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                if (opr == '+')
                    ss.push(num);
                else if (opr == '-')
                    ss.push(-num);
                else if (opr == '*')
                    ss.push(ss.pop() * num);
                else
                    ss.push(ss.pop() / num);
            } else {
                opr = c;
                i++;
            }
        }
        int ans = 0;
        while (!ss.isEmpty()) ans += ss.pop();
        return ans;
    }
}