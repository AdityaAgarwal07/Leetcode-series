class Solution {
    public int thirdMax(int[] nums) {
        Integer f = null;
        Integer s = f;
        Integer t = f;
        for(int n : nums){
            if(f == null || n > f){
                t = s;
                s = f;
                f = n;
            }else if(n == f){
                continue;
            }else if(s == null || n > s){
                t = s;
                s = n;
            }else if(n == s){
                continue;
            }else if(t == null || n > t){
                t = n;
            }
        }
        return (t == null) ? (int) f : (int) t;
    }
}