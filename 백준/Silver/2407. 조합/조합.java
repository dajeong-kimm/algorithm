import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		BigInteger[][] dp = new BigInteger[N+1][N+1];
		for (int i=0;i<=N;i++) {
			dp[i][i] = BigInteger.ONE;
			dp[i][0] = BigInteger.ONE;
		}
		
		for (int i=2;i<=N;i++) {
			for (int j=1;j<i;j++) {
				dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
			}
		}
		System.out.println(dp[N][M]);

	}

}