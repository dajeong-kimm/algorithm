import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1~N 번호가 매겨져 있는 도시들 
 * 도시 사이에는 길
 * 
 * 어느 한 외판원이 한 도시에서 출발해 N개의 도시를 거쳐 다시 원래의 도시로 돌아오는 순회 경로
 * 한번 갔던 도시로는 다시 갈 수 없음
 * 가장 적은 비용을 들이는 여행 계획
 * 
 * NP문제 : 계산 이론에서 해를 구하기 어려운 문제의 대표적인 사례
 * 출발 도시가 달라져도, 경로가 같으면 최소 비용이 같음
 * @author KOREA
 *
 */
public class Main {
	static int N;
	static int[][] arr;
	static int[][] dp;
	static int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[N][1<<N]; //dp 배열의 크기를 도시의 개수와 2^N (부분집합의 개수)로 설정
		//---------------------------------------------------
		for (int i=0;i<N;i++) {
			Arrays.fill(dp[i], -1);
		}
		
		//시작 도시를 0으로 가정하고 TSP 함수 호출
		System.out.println(tsp(0,1));
		
		

	}
	//현재 방문한 도시들의 집합을 인자로 받는 TSP 함수
	public static int tsp(int cur, int visited) {
		//모든 도시를 방문한 경우, 시작 도시로 돌아가는 비용 반환
		if (visited == (1<<N)-1) {
			return arr[cur][0] == 0 ? INF : arr[cur][0];
		}
		
		//이미 계산된 적이 있는 경우 메모이제이션된 값을 반환
		if (dp[cur][visited] != -1) {
			return dp[cur][visited];
		}
		
		//초기값을 큰 값으로 설정
		dp[cur][visited] = INF;
		
		//다른 모든 도시를 시도
		for (int next=0;next<N;next++) {
			//현재 도시에서 다음 도시로 갈 수 있는 경우 + 방문하지 않은 경우
			if (arr[cur][next] != 0 && (visited & (1<<next)) == 0) {
				int nextVisited = visited | (1<<next);
				dp[cur][visited] = Math.min(dp[cur][visited], tsp(next, nextVisited) + arr[cur][next]);
				
			}
		}
		
		return dp[cur][visited];
		
	}

}