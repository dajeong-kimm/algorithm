import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		long[] dp = new long[N+1];
		Deque<Integer> dq = new ArrayDeque<>();
		long max = Integer.MIN_VALUE;
		
		for (int i=1;i<=N;i++) {
			//윈도우 밖 (D) 제거
			while (!dq.isEmpty() && dq.peekFirst() < (i-D)) {
				dq.pollFirst();
			}
			
			//dp[i] 계산
			if (dq.isEmpty()) {
				dp[i] = arr[i];
			}
			else {
				//dp[j] (j < i) 중에서 최댓값
				dp[i] = arr[i] + Math.max(dp[dq.peekFirst()], 0);
			}
			
			if (dp[i] > max) max = dp[i];
			
			while (!dq.isEmpty() && dp[i] >= dp[dq.peekLast()]) {
				dq.pollLast();
			}
			
			dq.add(i);
			
		}
		
		System.out.println(max);
	}

}
