import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int MAX = 2_000_000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//K가 0일 경우 
		if (K == 0) {
			System.out.println(0);
			return;
		}
		
		int mount = 0;
		
		int[][] dp = new int[N+1][K+1];
		for (int i=0;i<=N;i++) {
			Arrays.fill(dp[i], MAX);
		}
		for (int i=0;i<=N;i++) {
			dp[i][0] = 0;
		}
		for (int i=1;i<=N;i++) {
			int cur = arr[i];
			mount += cur;
			
			for (int j=1;j<=K;j++) {
				//현재 카페인의 양보다 작으면
				if (j < cur) {
					dp[i][j] = dp[i-1][j];
				}
				
				//현재 카페인의양
				else if (j == cur) {
					dp[i][cur] = 1;
				}
				
				//현재 카페인의 양 초과
				else {
					if (j > mount) {
						dp[i][j] = MAX;
						continue;
					}
					dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-cur]+1);
				}
			}
			
		}
		
//		for (int i=1;i<=N;i++) {
//			for (int j=1;j<=K;j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		if (dp[N][K] == MAX || dp[N][K] == 0) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(dp[N][K]);
		
		
	}

}