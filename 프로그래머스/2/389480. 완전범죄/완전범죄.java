import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int cnt = info.length;
        
        int[][] dp = new int[cnt+1][m];
        for (int i=0;i<=cnt;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE/2);
        }
        dp[0][0] = 0;
        
        for (int i=1;i<=cnt;i++){
            int a = info[i-1][0];
            int b = info[i-1][1];
            
            for (int j=0;j<m;j++){
                //A가 훔칠때
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+a);
                
                //B가 훔칠때
                if (j+b < m) {
                    dp[i][j+b] = Math.min(dp[i][j+b], dp[i-1][j]);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int j=0;j<m;j++){
            min = Math.min(min, dp[cnt][j]);
        }
        int answer = (min >= n) ? -1 : min;
        return answer;
    }
}