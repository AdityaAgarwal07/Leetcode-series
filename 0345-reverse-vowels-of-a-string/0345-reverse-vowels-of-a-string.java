class Solution {
    char[] arr = {'a', 'e', 'i', 'o', 'u'};
    public String reverseVowels(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        char[] ch = s.toCharArray();
        while(i < j){
            while(i < j && !find(ch[i])) i++;
            while(i < j && !find(ch[j])) j--;
            if(i >= j) break;
            swap(ch, i, j);
            i++;
            j--;
        }
        return String.valueOf(ch);
    }
    private void swap(char[] ch, int i, int j){
        char c = ch[i];
        ch[i] = ch[j];
        ch[j] = c;
    }
    private boolean find(char ch){
        for(char c : arr){
            if(Character.toLowerCase(ch) == c) return true;
        }
        return false;
    }
}