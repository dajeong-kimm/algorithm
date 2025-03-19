class Solution {
    static int n;
    static int[][] dp;
    public int solution(int[][] triangle) {
        n = triangle.length;
        
        dp = new int[n+1][n+1];
        for (int i=1;i<=n;i++){
            dp[n][i] = triangle[n-1][i-1];
        }
        
        for (int i=n-1;i>=1;i--){
            for (int j=1;j<=i;j++){
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + triangle[i-1][j-1];
            }
        }
        
        return dp[1][1];
    }
}