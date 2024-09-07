import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 앱
 * 실행중인 앱과 활성화된 앱
 * 활성화 : 화면에 보이지 않더라도 메인 메모리에 직전의 상태가 기록되어 있는 것
 * 비활성화 : 새로운 앱을 실행시키기 위해 필요한 메모리가 부족해지면 활성화 된 앱들 중 몇개를 선택하여 삭제
 * 
 * N개의 앱 (가각 m바이트 만큼 사용)
 * c : 비활성화 후 다시 실행할때 추가적으로 들어가는 비용
 * 
 * 새로운 앱 B --> 추가로 M바이트의 메모리 필요
 * 
 * ci의 합을 최소화하여 필요한 메모리 M바이트를 확보하는 방법
 * @author KOREA
 *
 */
public class Main {
	static int N,M; //1<=N<=100 , 1<=M<=10_000_000
	static int[] arr; // 1<=mi<=10_000_000
	static int[] cost; 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //활성화 어플의 개수
		M = Integer.parseInt(st.nextToken()); //확보해야하는 메모리
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N+1];
		for (int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		cost = new int[N+1];
		long total_cost = 0;
		for (int i=1;i<=N;i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			total_cost += cost[i];
		}
		
		long[][] dp = new long[N+1][(int) total_cost+1];
		
		long answer = 0;
		for (int i=1;i<=N;i++) {
			for (int j=0;j<=total_cost;j++) {
				if (j >= cost[i]) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i]] + arr[i]);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		for (int j=0;j<=total_cost;j++) {
			if (dp[N][j] >= M) {
				System.out.println(j);
				break;
			}
		
		}
		
	}

}