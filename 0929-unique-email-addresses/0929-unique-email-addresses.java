class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String s : emails){
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while(s.charAt(j) != '@' && s.charAt(j) != '+'){
                if(s.charAt(j) != '.') sb.append(s.charAt(j));
                j++;
            }
            while(s.charAt(j) != '@') j++;
            while(j < s.length()) sb.append(s.charAt(j++));
            set.add(sb.toString());
        }
        return set.size();
    }
}