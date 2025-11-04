class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1_000_000_007;
        long[] dp = new long[n + 2];
        long[] prefix = new long[n + 2];
        dp[1] = 1;
        prefix[1] = 1;

        for (int day = 2; day <= n; day++) {
            int start = Math.max(0, day - forget);
            int share = Math.max(0, day - delay);
            dp[day] = (prefix[share] - prefix[start] + MOD) % MOD;
            prefix[day] = (prefix[day - 1] + dp[day]) % MOD;
        }

        long result = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            if (i > 0) result = (result + dp[i]) % MOD;
        }

        return (int) result;
    }
}
