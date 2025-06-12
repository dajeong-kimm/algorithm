import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[10_001];
		Arrays.fill(dp, 1);
		for (int i=2;i<=10_000;i++) {
			dp[i] += dp[i-2];
		}
		for (int i=3;i<=10_000;i++) {
			dp[i] += dp[i-3];
		}
		
		for (int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb);
	}

}
