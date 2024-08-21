import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * N*N 배열
 * A[i][j] = i*j
 * 
 * 이 수를 일차원 배열 B에 넣으면 B의 크기는 N*N
 * B를 오름차순 정렬했을 때 B[k]는?
 * 
 * 배열 A와 B의 인덱스는 1부터 시작
 * 
 * N<=10^5
 * k <= min(10^9, N^2)
 * @author KOREA
 *
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int start = 0;
		int end = k;
		
		
		int answer = 0;
		
		while (start <= end) {
			int mid = (start+end)/2;
			
			int cnt = 0;
			
			for (int i=1;i<=N;i++) {
				cnt += Math.min(mid/i, N);
				
				
			}
			
			if (cnt >= k) {
				answer = mid;
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		System.out.println(answer);

	}

}
