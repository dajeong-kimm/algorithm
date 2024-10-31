import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N행 M열
 * 하나의 격자 누르기 --> 연결된 모든 칸들의 색 반전
 * 연결 : 두 격자가 같은 색이면서 변을 공유하는 격자들
 * 
 * 초기 상태로 가능한 경우의 수 % 1_000_000_007
 * @author KOREA
 *
 */
public class Main {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[N][M];
		for (int i=0;i<N;i++) {
			String input = br.readLine();
			for (int j=0;j<M;j++) {
				arr[i][j] = input.charAt(j);
			}
		}
		
		long answer = 0;
		int cnt = 0;
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				char tmp = arr[i][j];
				
				for (int d=0;d<4;d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					
					if (nx>=0 && nx<N && ny>=0 && ny<M) {
						if (arr[nx][ny] != tmp) {
							cnt++;
							break;
						}
					}
				}
			}
		}
		
		answer = modPow(2, N*M-cnt, 1_000_000_007);
		System.out.println(answer);
		
		
		
	}
	static long modPow(long base, long exp, long mod) {
		long result = 1;
		base = base % mod;
		
		while (exp > 0) {
			if ((exp & 1) == 1) {
				result = (result * base) % mod;
			}
			exp >>= 1;
			base = (base * base) %mod;
		}
		return result;
	}

}