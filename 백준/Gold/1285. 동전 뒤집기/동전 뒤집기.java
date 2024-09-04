import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 동전 뒤집기
 * N^2개의 동전 : N행 N열
 * 앞면이 H 뒷면이 T
 * 임의의 한 행 또는 한 열에 놓인 N개의 동전을 모두 뒤집는 작업 가능
 * 뒷면이 위를 향하도록 놓인 동전의 개수를 2보다 작게 만들 수는 없다.
 * 
 * 초기 상태 주어질 때, 
 * 뒤집기 작업을 수행하여 뒷면이 위를 향하는 동전개수를 최소로 ,,
 * 1<=N<=20
 * @author KOREA
 *
 */
public class Main {
	//T이면 1로 저장하기
	static int N;
	static int[][] arr;
	static int answer;
	static boolean flag = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for (int i=0;i<N;i++) {
			String input = br.readLine();
			for (int j=0;j<N;j++) {
				if (input.charAt(j) == 'T') arr[i][j] = 1;
			}
		}
		
		answer = 1_000; //최소 2개임
		
		//총 가능한 경우의수 --> 2^2N
		//행 ---> 열 (0 1 2 3 4 5)
		coinReverse();
		
		System.out.println(answer);
	}
	public static void coinReverse() {
		for (int mask = 0; mask<(1<<N) ; mask++) {
			int sum = 0;
			for (int j=0;j<N;j++) {
				int count = 0;
				for (int i=0;i<N;i++) {
					int tmp = arr[i][j];
					if ((mask & (1<<i)) != 0) {
						tmp ^= 1;
					}
					if (tmp == 1) count++;
				}
				sum += Math.min(count, N-count);
			}
			answer = Math.min(answer, sum);
		}
	}
	
//	public static void reverse(int n) {
//		if (n<N) {
//			for (int j=0;j<N;j++) {
//				arr[n][j] ^= 1;
//			}
//		}
//		else if (n>=N) {
//			int c = n-N;
//			for (int j=0;j<N;j++) {
//				arr[c][j] ^= 1;
//			}
//		}
//	}
//	public static int count() {
//		int result = 0;
//		for (int i=0;i<N;i++) {
//			for (int j=0;j<N;j++) {
//				if (arr[i][j] == 1) result++;
//			}
//		}
//		return result;
//	}

}