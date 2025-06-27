class Solution {
    static long MOD = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        boolean board[][] = new boolean[m][n];
        for (int i=0;i<puddles.length;i++) {
            int x = puddles[i][0];
            int y = puddles[i][1];
            board[x-1][y-1] = true;
        }
        
        long[][] dp = new long[m][n];
        dp[0][0] = 1;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++) {
                if (board[i][j]) continue;
                
                if (i-1 >= 0 && !board[i-1][j]) {
                    dp[i][j] += (dp[i-1][j]%MOD);
                }
                if (j-1 >= 0 && !board[i][j-1]) {
                    dp[i][j] += (dp[i][j-1]%MOD);
                }
            }
        }
        return (int) (dp[m-1][n-1]%MOD);
    }
}