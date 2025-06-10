import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int MOD = 1_000_000_003;
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		if (K > (N/2)) {
			System.out.println(0);
			return;
		}
		
		long[][] dp = new long[N+1][K+1];
		
		for (int i=0;i<=N;i++) {
			dp[i][0] = 1;
			dp[i][1] = i;
		}
		
		for (int i=2;i<N;i++) {
			for (int j=2;j<=K;j++) {
				dp[i][j] = (dp[i-2][j-1] + dp[i-1][j]) % MOD;
			}
		}
		
		long answer = (dp[N-3][K-1] + dp[N-1][K]) % MOD;
		
		System.out.println(answer);
		
	}

}
