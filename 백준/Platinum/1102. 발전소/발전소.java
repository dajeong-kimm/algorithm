import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 발전소
 * 
 * 발전소를 고치는 방법 : 고장나지 않은 발전소를 이용해서 고장난 발전소를 재시작
 * 이때 비용이 발생 ,, 어떤 발전소에서 어떤 발전소를 재시작하느냐에 따라 다름
 * 
 * 각 발전소가 켜져있으면 Y, 꺼져있으면 N
 * 비용은 36보다 작거나 같은 음이 아닌 정수 ,, P는 0보다 크거나 같고 N보다 작거나 같은 정수
 * 
 * 적어도 P개의 발전소가 고장나 있지 않도록, 발전소를 고치는 비용의 최솟값
 * dp[status] : 특정 상태에서 모든 발전소를 켜는 데 드는 최소 비용
 * @author KOREA
 *
 */
public class Main {
	static int N; //발전소의 개수 (N<=16)
	static int[][] cost;
	static boolean[] lightOn;
	static int P;
	static int[] dp;
	static int INF = Integer.MAX_VALUE;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		lightOn = new boolean[N];
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		String input = br.readLine();
		int initStatus = 0;
		int onCount = 0;
		for (int i=0;i<N;i++) {
			//발전소가 켜져 있으면 true로 저장
			if (input.charAt(i) == 'Y') {
				lightOn[i] = true;
				initStatus |= (1<<i);
				onCount++;
			}
			
		}
		
		P = Integer.parseInt(br.readLine());
		
		dp = new int[1<<N];
		//----------------------------------------------- input
		//이미 P개 이상의 발전소가 켜져 있는 경우
		if (onCount >= P) {
			System.out.println(0);
			return;
		}
		
		for (int i=0;i<(1<<N);i++) {
			dp[i] = -1;
		}
		
		int result = solve(initStatus, onCount);
		System.out.println(result == INF ? -1 : result);

	}
	static int solve(int status, int onCount) {
		if (onCount >= P) {
			return 0;
		}
		
		if (dp[status] != -1) return dp[status];
		
		dp[status] = INF;
		
		//모든 발전소를 확인하여 고장난 발전소를 고치는 비용 계산
		for (int i=0;i<N;i++) {
			//i번째 발전소가 켜져 있는 경우
			if ((status & (1<<i)) != 0) {
				for (int j=0;j<N;j++) {
					//j번째 발전소가 꺼져 있는 경우
					if ((status & (1<<j)) == 0) {
						int newStatus = status | (1<<j);
						dp[status] = Math.min(dp[status], solve(newStatus, onCount+1) + cost[i][j]);
					}
				}
			}
		}
		
		return dp[status];
	}

}