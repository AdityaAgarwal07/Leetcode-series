class Solution {
    class Pair{
        String ss;
        int nn;
        Pair(String ss, int nn){
            this.ss = ss;
            this.nn = nn;
        }
    }
    public int ladderLength(String ttt, String t, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(t)) return 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(ttt, 1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            String s = p.ss;
            int n = p.nn;
            if(t.equals(s)) return n;
            StringBuilder sb = new StringBuilder(s);
            for(int i = 0; i < s.length(); i++){
                char cc = s.charAt(i);
                for(int j = 0; j < 26; j++){
                    char c = (char) (j + 'a');
                    if(c == cc) continue;
                    sb.setCharAt(i, c);
                    String a = sb.toString();
                    if(set.contains(a)){
                        set.remove(a);
                        q.offer(new Pair(a, n + 1));
                    }
                }
                sb.setCharAt(i, cc);
            }
        }
        return 0;
    }
}