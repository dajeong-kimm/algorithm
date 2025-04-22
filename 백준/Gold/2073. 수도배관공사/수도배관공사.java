import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int D, P;
	
	static int MAX = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[D+1];
		Arrays.fill(dp, -1);
		for (int i=0;i<P;i++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if (L > D) continue;
			for (int j=D;j>=L+1;j--) {
				if (dp[j-L] == -1) continue;
				dp[j] = Math.max(dp[j], Math.min(dp[j-L], C));
			}
			dp[L] = Math.max(dp[L], C);
//			System.out.println(Arrays.toString(dp));
		}
		System.out.println(dp[D]);
	}

}
