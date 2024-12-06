import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		int[] arr = new int[N];
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = 1;
		
		if (N == 1 && M == 0) {
			System.out.println(0);
			return;
		}
		
		long answer = Long.MAX_VALUE;
		while (left < N-1) {
			long diff = arr[right] - arr[left];
			
			if (diff == M) {
				System.out.println(M);
				return;
			}
			
			if (diff > M) {
				answer = Math.min(answer, diff);
				left++;
				right = left + 1;
				continue;
			}
			
			right++;
			if (right == N) {
				left++;
				right = left+1;
			}
		}
		
		System.out.println(answer);

	}

}