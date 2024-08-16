import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 메모리 : 
 * 시간 : 
 * 
 * N개의 재료
 * 각 재료는 신맛 S , 쓴맛 B
 * 신맛은 사용한 재료의 신맛의 곱, 쓴맛은 합
 * 
 * 재료를 적절히 섞어서 요리의 신맛과 쓴맛의 차이를 작게 만드려고 함
 * 재료는 적어도 하나 사용해야 함
 */
public class Main {
	static int N;
	static int[][] arr;
	static long answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		answer = Long.MAX_VALUE;
		DFS(0,0,0);
		System.out.println(answer);
		
		
	}
	private static void DFS(int start, int cur_s, int cur_b) {
		for (int i=start;i<N;i++) {
			int new_s = 0;
			int new_b = 0;
			if (cur_s == 0) {
				new_s = arr[i][0];
			} else {
				new_s = cur_s * arr[i][0];
			}
			new_b = cur_b + arr[i][1];
			int new_diff = Math.abs(new_s - new_b);
			answer = Math.min(answer, new_diff);
			DFS(i+1, new_s, new_b);
		}
	}

}