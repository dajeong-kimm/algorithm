import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 메모리 : 
 * 시간 : 
 * 
 * 제한 칼로리 이하의 조합 중에서 가장 높은 선호도 구하기
 * 첫번째 시도 (재귀 함수 이용 --> 모든 조합 구하기) : 시간초과
 * 두번째 시도 DP (냅색과 비슷)
 * dp[i][j] : i번째 햄버거까지 j칼로리까지 먹었을 때 최대 선호도
 *
 */
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][2];
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				
				arr[i][0] = a; //맛에 대한 점수
				arr[i][1] = b; //칼로리
			}
			
			int[][] dp = new int[N+1][L+1];
			
			for (int i=1;i<=N;i++) {
				for (int j=1;j<=L;j++) {
					dp[i][j] = dp[i-1][j];
					if (j>=arr[i-1][1]) {
						dp[i][j] = Math.max(dp[i][j], dp[i-1][j-arr[i-1][1]] + arr[i-1][0]);
					} 
				}
			}
			int answer = dp[N][L];
			System.out.println("#"+t+" "+answer);
		}
	}

}