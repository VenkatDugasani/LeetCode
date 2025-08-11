class Solution {
     private static final int MOD = 1_000_000_007;
    public int[] productQueries(int n, int[][] queries) {
          int[] powers = new int[31];
        int m = 0, bit = 0, tmp = n;
        while (tmp > 0) {
            if ((tmp & 1) == 1) powers[m++] = 1 << bit; // 2^bit fits in int (bit ≤ 29)
            tmp >>= 1;
            bit++;
        }

        // Hint 2: brute-force multiply per query (m ≤ 30)
        int[] ans = new int[queries.length];
        for (int qi = 0; qi < queries.length; qi++) {
            int L = queries[qi][0], R = queries[qi][1];
            long prod = 1;
            for (int j = L; j <= R; j++) {
                prod = (prod * powers[j]) % MOD;
            }
            ans[qi] = (int) prod;
        }
        return ans;
    }
}