import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N+1];
		long[] prefixSum = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
			prefixSum[i] = prefixSum[i-1] + A[i];
		}
		
		Stack<Integer> stack = new Stack<>();
		long maxScore = 0;
		
		for (int i=1;i<=N;i++) {
			//현재 원소보다 작은 값이 스택에 있을때까지 팝
			while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
				int heightIdx = stack.pop();
				int left = stack.isEmpty() ? 1 : stack.peek() + 1;
				int right = i-1;
				
				//구간합계산
				long sum = prefixSum[right] - prefixSum[left-1];
				long score = sum * A[heightIdx];
				maxScore = Math.max(maxScore, score);
			}
			stack.push(i);
		}
		
		//스택에 남은 원소 처리
		while (!stack.isEmpty()) {
			int heightIdx = stack.pop();
			int left = stack.isEmpty() ? 1 : stack.peek() +1;
			int right = N;
			
			long sum = prefixSum[right] - prefixSum[left-1];
			long score = sum * A[heightIdx];
			maxScore = Math.max(maxScore, score);
		}
		System.out.println(maxScore);
	}

}
