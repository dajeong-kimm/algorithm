import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] board;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        dp = new int [n][m][3];
        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j],(int)1e9);
            }
        }

        for (int j=0;j<m;j++){
            dp[0][j][0] = board[0][j];
            dp[0][j][1] = board[0][j];
            dp[0][j][2] = board[0][j];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(j == 0) {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + board[i][j];
                    dp[i][j][1] = dp[i - 1][j][0] + board[i][j];
                } else if(j == m - 1) {
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + board[i][j];
                    dp[i][j][1] = dp[i - 1][j][2] + board[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + board[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + board[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + board[i][j];
                }
            }
        }

        int min = (int)1e9;
        for (int j=0;j<m;j++){
            for (int i=0;i<3;i++){
                min = Math.min(min,dp[n-1][j][i]);
            }
        }
        System.out.println(min);
    }
}