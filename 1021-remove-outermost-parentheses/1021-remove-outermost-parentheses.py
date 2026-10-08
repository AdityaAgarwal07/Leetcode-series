class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        start = 0
        bal = 0
        lst = []

        for i , char in enumerate(s):
            if char == "(":
                if bal == 0:
                    start = i
                bal += 1
            elif char == ")":
                bal -= 1
                if bal == 0:
                    lst.append(s[start+1:i])
                    
        return "".join(lst)
        