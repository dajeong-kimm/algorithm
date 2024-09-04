import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 계단 수
 * 45656 (인접한 모든 자리의 차이가 1)
 * 
 * 길이가 N이면서 0부터 9까지 숫자가 모두 등장하는 계단수가 총 몇개있는지 구하기
 * 1<N<100
 * 정답을 1_000_000_000으로 나눈 나머지를 출력
 * 
 * dp[i][j][k]
 * - i : 현재 자리수 (1~N)
 * - j : 현재 자리의 숫자 (0 ~ 9)
 * - k : 사용된 숫자를 비트마스크로 표현 (0부터 1023까지)
 * 1023 : 1111111111
 * 
 * answer : dp[N][j][1023] : (j는 0부터 9까지) 모두 더한 값
 * @author KOREA
 *
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		final int MOD = 1_000_000_000;
		
		long [][][] dp = new long[N+1][10][1024];
		
		for (int j=1;j<=9;j++) {
			dp[1][j][1<<j] = 1;
		}
		
		for (int i=2;i<=N;i++) {
			for (int j=0;j<=9;j++) {
				for (int k=0;k<1024;k++) {
					if (j>0) {
						dp[i][j][k | (1<<j)] += dp[i-1][j-1][k];
						dp[i][j][k | (1<<j)] %= MOD;
					}
					if (j<9) {
						dp[i][j][k | (1<<j)] += dp[i-1][j+1][k];
						dp[i][j][k | (1<<j)] %= MOD;
					}
				}
			}
		}
		
		long answer = 0;
		for (int j=0;j<=9;j++) {
			answer += dp[N][j][1023];
			answer %= MOD;
		}
		System.out.println(answer);
	}

}