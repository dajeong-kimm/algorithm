import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int answer = 0;
	static int N;
	static int[] arr;
	static int[] sum;
	static int max, total;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		sum = new int[N+1];
		for (int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum[i] = sum[i-1]+arr[i];
		}
		
		total = sum[N];
		max = sum[N]/2;
		
		A: for (int i=1;i<=N;i++) {
			
			int start = i+1;
			int end = N;
			while (start<=end) {
				int mid = (start+end)/2;
				
				//i에서 mid까지
				int dist = sum[mid-1]-sum[i-1];
				int trueDist = Math.min(dist,  total-dist);
				answer = Math.max(answer, trueDist);
				//가능한 최댓값이 이미 나오면 
				if (answer == max) {
					System.out.println(answer);
					return;
				}
				if (dist > max) {
					end = mid-1;
				}
				else {
					start = mid+1;
				}
			}
		}
		
		System.out.println(answer);
	}

}