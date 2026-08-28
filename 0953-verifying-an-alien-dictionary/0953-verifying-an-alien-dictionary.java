class Solution {
    public boolean isAlienSorted(String[] words, String o) {
        int n = words.length;
        List<Character>[] nums = new ArrayList[26];
        for(int i = 0; i < 26; i++) nums[i] = new ArrayList<>();
        for(int i = 0; i < n - 1; i++){
            String s1 = words[i];
            String s2 = words[i + 1];
            int j = 0;
            while (j < s1.length() && j < s2.length() && s1.charAt(j) == s2.charAt(j)){
                j++;
            }
            if (j == s2.length() && j < s1.length()) return false;
            if (j < s1.length() && j < s2.length()) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                nums[c1 - 'a'].add(c2);
            }
        }
        for(int i = 0; i < 26; i++){
            if(nums[i].size() != 0){
                char c = (char) (i + 'a');
                int nn = o.indexOf(c);
                for(char cc : nums[i]){
                    int mm = o.indexOf(cc);
                    if(nn > mm) return false;
                }
            }
        }
        return true;
    }
}