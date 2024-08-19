import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이전 코드와 같지만 NCN/2를 계산해서 그만큼만 조합 생성
 * @author KOREA
 *
 */
public class Solution {

static int answer;
	
	static int N;
	static int[][] arr;
	
	static boolean[] visited;
	
	static long time;
	
	static long limit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N][N];
			
			visited = new boolean[N];
			
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] dp = new int[N+1][N+1];
			for (int i=0;i<=N;i++) {
				dp[i][i] = 0;
				dp[i][0] = 1;
			}
			
			for (int i=2;i<=N;i++) {
				for (int j=1;j<i;j++) {
					dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
				}
			}
			
			limit = dp[N][N/2];
			
			time = 0;
			answer = Integer.MAX_VALUE;
			Combi(0,0);
			System.out.println("#"+t+" "+answer);
			
			
		}
		

	}
	private static void Combi(int cnt,int start) {
		if (time>limit) {
			return;
		}
		
		if (cnt == N/2) {
			time++;
			int a = 0;
			int b = 0;
			for (int i=0;i<N-1;i++) {
				for (int j=i+1;j<N;j++) {
					if (visited[i] && visited[j]) {
						a += arr[i][j];
						a += arr[j][i];
					} else if (!visited[i] && !visited[j]) {
						b += arr[i][j];
						b += arr[j][i];
					}
				}
			}
			answer = Math.min(answer,Math.abs(a-b));
			return;
		}
		for (int i=start;i<N;i++) {
			if (!visited[i]) {
				visited[i] = true;
				Combi(cnt+1, i+1);
				visited[i] = false;
			}
		}
	}


}