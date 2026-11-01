class Solution {
    public int sumFourDivisors(int[] nums) {
        int[] memo = new int[100001];
        Arrays.fill(memo, -1);

        int ans = 0;
        for (int n : nums) {
            if (memo[n] != -1) {
                ans += memo[n];
                continue;
            }

            int sum = getSumIfFourDivisors(n);
            memo[n] = sum;
            ans += sum;
        }
        return ans;
    }

    private int getSumIfFourDivisors(int n) {
        int count = 0, sum = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                int d1 = i;
                int d2 = n / i;

                count++;
                sum += d1;

                if (d1 != d2) {
                    count++;
                    sum += d2;
                }

                if (count > 4) return 0;
            }
        }
        return count == 4 ? sum : 0;
    }
}
