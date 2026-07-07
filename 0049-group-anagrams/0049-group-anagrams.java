class Solution {
    public List<List<String>> groupAnagrams(String[] nums) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : nums){
            char[] cc = s.toCharArray();
            Arrays.sort(cc);
            String ss = String.valueOf(cc);
            if(!map.containsKey(ss)){
                map.put(ss, new ArrayList<>());
            }
            map.get(ss).add(s);
        }
        return new ArrayList<>(map.values());
    }
}