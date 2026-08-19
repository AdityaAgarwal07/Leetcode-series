class Solution {
    public int maxNumberOfFamilies(int n, int[][] nn) {
        HashMap<Integer, HashSet<Integer>> nums = new HashMap<>();
        int[] aa = {1, 2, 3, 4};
        int[] bb = {3, 4, 5, 6};
        int[] cc = {5, 6, 7, 8};
        for(int[] arr : nn){
            int a = arr[0] - 1;
            int b = arr[1] - 1;
            nums.computeIfAbsent(a, k -> new HashSet<>()).add(b);
        }
        int ans = (n - nums.size()) * 2;
        for(int i : nums.keySet()){
            HashSet<Integer> row = nums.get(i);
            boolean ab = true;
            boolean ac = true;
            boolean ad = true;
            for(int m : aa){
                if(row.contains(m)){
                    ab = false;
                    break;
                }
            }
            for(int m : bb){
                if(row.contains(m)){
                    ac = false;
                    break;
                }
            }
            for(int m : cc){
                if(row.contains(m)){
                    ad = false;
                    break;
                }
            }
            if(ab && ad) ans += 2;
            else if(ab || ac || ad) ans++;
        }
        return ans;
    }
}