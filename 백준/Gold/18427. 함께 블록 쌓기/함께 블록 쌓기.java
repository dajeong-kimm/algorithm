import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int MOD = 10007;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		List<Integer> list[] = new ArrayList[N+1];
		for (int i=0;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		long[][] dp = new long[N+1][H+1];
		dp[0][0] = 1;
		for (int i=1;i<=N;i++) {
			for (int j=0;j<=H;j++) { //i-1번째 친구가 쌓은 경우의 수 가져오기
				dp[i][j] = dp[i-1][j];
			}
			
			for (int h : list[i]) {
				for (int j=0;j+h<=H;j++) {
					dp[i][j+h] = (dp[i][j+h] + dp[i-1][j]) % MOD;
//					dp[i][j+h] += dp[i-1][j];
				}
			}
		}
		System.out.println(dp[N][H]%10007);
		
	}

}
