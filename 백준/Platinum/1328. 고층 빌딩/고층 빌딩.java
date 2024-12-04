import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		long[][][] dp = new long[N+1][L+1][R+1];
		
		dp[1][1][1] = 1;
		
		for (int i=2;i<=N;i++) {
			for (int l=1;l<=L;l++) {
				for (int r=1;r<=R;r++) {
					//왼쪽에 가장 높은 빌딩 추가
					dp[i][l][r] += dp[i-1][l-1][r];
					dp[i][l][r] %= MOD;
					
					//오른쪽에 가장 높은 빌딩 추가
					dp[i][l][r] += dp[i-1][l][r-1];
					dp[i][l][r] %= MOD;
					
					//중간에 빌딩 추가
					dp[i][l][r] += dp[i-1][l][r] * (i-2);
					dp[i][l][r] %= MOD;
				}
			}
		}
		
		System.out.println(dp[N][L][R]);

	}

}