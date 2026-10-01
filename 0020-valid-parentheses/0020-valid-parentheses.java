class Solution {
    public boolean isValid(String ss) {
        Stack<Character> s = new Stack<>();
        for(char c : ss.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                s.push(c);
            }else{
                if(s.isEmpty()) return false;
                char sss = s.peek();
                if(c == ')' && sss == '(' || c == ']' && sss == '[' || c == '}' && sss == '{') s.pop();
                else return false;
            }
        }
        return s.isEmpty();
    }
}