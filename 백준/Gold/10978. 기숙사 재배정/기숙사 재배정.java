import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[21];
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 9;
		
		for (int i=5;i<=20;i++) {
			dp[i] = (dp[i-1]+dp[i-2]) * (i-1);
		}
		
		for (int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
	}

}
