class Solution {
    public List<List<String>> findLadders(String beginWord, String t, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(t))
            return new ArrayList<>();

        set.remove(beginWord);

        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new ArrayDeque<>();

        q.offer(beginWord);
        map.put(beginWord, 0);

        boolean aa = false;
        int l = 0;

        // BFS
        while (!q.isEmpty() && !aa) {
            Set<String> vis = new HashSet<>();
            int n = q.size();

            while (n-- > 0) {
                String s = q.poll();

                if (s.equals(t)) {
                    aa = true;
                    break;
                }

                StringBuilder sb = new StringBuilder(s);

                for (int i = 0; i < s.length(); i++) {
                    char cc = s.charAt(i);

                    for (int j = 0; j < 26; j++) {
                        char c = (char) (j + 'a');

                        if (c == cc)
                            continue;

                        sb.setCharAt(i, c);
                        String ss = sb.toString();

                        if (set.contains(ss) && vis.add(ss)) {
                            q.offer(ss);
                            map.put(ss, l + 1);
                        }
                    }

                    sb.setCharAt(i, cc);
                }
            }

            l++;

            for (String x : vis)
                set.remove(x);
        }

        if (!map.containsKey(t))
            return new ArrayList<>();

        // Reverse BFS
        List<List<String>> ans = new ArrayList<>();
        Queue<List<String>> q1 = new ArrayDeque<>();

        List<String> arr = new ArrayList<>();
        arr.add(t);
        q1.offer(arr);

        while (!q1.isEmpty()) {
            arr = q1.poll();

            String s = arr.get(0);

            if (s.equals(beginWord)) {
                ans.add(new ArrayList<>(arr));
                continue;
            }

            int level = map.get(s);

            StringBuilder sb = new StringBuilder(s);

            for (int i = 0; i < s.length(); i++) {
                char cc = s.charAt(i);

                for (int j = 0; j < 26; j++) {
                    char c = (char) (j + 'a');

                    if (c == cc)
                        continue;

                    sb.setCharAt(i, c);
                    String ss = sb.toString();

                    if (map.containsKey(ss) && map.get(ss) == level - 1) {
                        List<String> ab = new ArrayList<>(arr);
                        ab.add(0, ss);
                        q1.offer(ab);
                    }
                }

                sb.setCharAt(i, cc);
            }
        }

        return ans;
    }
}