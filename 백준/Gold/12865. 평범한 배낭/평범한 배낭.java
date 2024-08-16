import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * dp[i][j] : i번째 물건까지 고려했을 때 무게 j로 얻을 수 있는 최대 가치
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][2];
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); //무게
			arr[i][1] = Integer.parseInt(st.nextToken()); //가치
		}
		
		int[][] dp = new int[n+1][k+1];
		//물건의 개수 만큼
		for (int i=1;i<=n;i++) {
			//배낭의 최대 무게 만큼
			for (int j=1;j<=k;j++) {
				if (j >= arr[i-1][0]) {
					dp[i][j] = Math.max(arr[i-1][1] + dp[i-1][j - arr[i-1][0]], dp[i-1][j]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}
}