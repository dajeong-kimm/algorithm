import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 사회망 서비스(SNS)
 * 주어진 친구 관계 그래프에서 아이디어를 전파하는데 필요한 얼리 아답터의 최소 수
 * 
 * 트리의 정점 개수 N (2<=N<=1_000_000)
 * 
 * @author KOREA
 *
 */
public class Main {
	static int N;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][2];
		visited = new boolean[N+1];
		graph = new ArrayList[N+1];
		for (int i=1;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.valueOf(st.nextToken());
			int end = Integer.valueOf(st.nextToken());
			graph[start].add(end);
			graph[end].add(start);
		}
		
		dfs(1);
		//부모 노드가 얼리어답터가 아닐때와 일때의 최솟값
		System.out.println(Math.min(dp[1][0], dp[1][1]));
		

	}
	public static void dfs(int num) {
		visited[num] = true;
		dp[num][0] = 0; //해당 num이 얼리어답터가 아닌 경우
		dp[num][1] = 1; //해당 num이 얼리어답터인 경우
		
		for (int child : graph[num]) {
			if (!visited[child]) {
				dfs(child); //자식 노드의 dp값을 미리 구함
				dp[num][0] += dp[child][1];
				dp[num][1] += Math.min(dp[child][0], dp[child][1]);
			}
		}
	}

}