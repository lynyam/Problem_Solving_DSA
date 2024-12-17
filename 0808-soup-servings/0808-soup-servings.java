class Solution {
    double[][] dp;
    public double soupServings(int n) {
        if (n > 4800) {
            return 1.0;
        }
        n = (int)Math.ceil(n / 25.0);
        dp = new double[n + 1][n + 1];
        int i = 0;
        while (i <= n) {
            Arrays.fill(dp[i++], -1);
        }
        return (helper(n, n));
    }

    public double helper(int soupA, int soupB) {
        if (soupA <= 0 && soupB <= 0)
            return (0.5);
        if (soupA <= 0)
            return (1.0);
        if (soupB <= 0)
            return (0.0);
        if (dp[soupA][soupB] != -1)
            return (dp[soupA][soupB]);
        double ope1 = helper(soupA - 4, soupB);
        double ope2 = helper(soupA - 3, soupB - 1);
        double ope3 = helper(soupA - 2, soupB - 2);
        double ope4 = helper(soupA - 1, soupB - 3);
        dp[soupA][soupB] = (ope1 + ope2 + ope3 + ope4) * 0.25;
        return (dp[soupA][soupB]);
    }
}
/*
                                100
    0,100                     25,100                50,50                       75,25
    |                     /  \    \      \         /\      \   \                / \ \       \
    1               -75,100 -50,75 -25,50 0,25  0,50 -25,25 0,0 25,-25.   -25,25 0,0 25,-25 25,-50 
                    |        |      |       |.   |.    |      |.  |.         |.   |.    |.    |
                    1        1      1       1.   1     1      0.5   0        1.   0.5   0.    0
*/