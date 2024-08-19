import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 서쪽에는 N개의 사이트, 동쪽에는 M개의 사이트 (N<=M)
 * 
 * 다리를 지을 수 있는 경우의 수 구하기
 * 
 * dp[n][r] = dp[n-1][r-1] + dp[n-1][r]
 * @author KOREA
 *
 */
public class Main {
	static int N,M;
	static long[][] dp = new long[30][30];
	
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		sb = new StringBuilder();
		
		for (int i=0;i<30;i++) {
			dp[i][i] = 1;
			dp[i][0] = 1;
		}
		
		for (int i=2;i<30;i++) {
			for (int j=1;j<=i;j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			sb.append(dp[M][N]).append("\n");
		}
		
		System.out.println(sb);

	}

}