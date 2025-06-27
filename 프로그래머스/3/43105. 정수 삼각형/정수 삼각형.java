import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length;
        
        int[][] dp = new int[N+1][N+1];
        for (int i=1;i<=N;i++) {
            dp[N][i] = triangle[N-1][i-1];
        }
        
        for (int i=N-1;i>=1;i--) {
            for (int j=1;j<=i;j++) {
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + triangle[i-1][j-1];
            }
        }
        return dp[1][1];
    }
}