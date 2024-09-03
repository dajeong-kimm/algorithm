import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 도로포장
 * K개의 도로를 포장하여 시간 단축
 * 
 * K개 이하의 도로 포장
 * 도로는 이미 있는 도로만 포장 가능
 * 포장하게 되면 걸리는 시간 0
 * 
 * dp[j][k] --> k개 이하의 도로를 포장하면서 j번 도시까지 가는 최소 시간
 * 지금까지 포장한 도로 개수 count에서 1개 더 지웠을 때를 검사하면서 dp 채우기
 * @author KOREA
 *
 */
public class Main {
	static int N,M,K;
	static int[] dist;
	static ArrayList<Node> graph[];
	
	static long[][] dp;
	
	static long INF = Long.MAX_VALUE;
	
	static class Node implements Comparable<Node>{
		int n;
		long cost;
		int count;
		Node(int n, long cost, int count){
			this.n = n;
			this.cost = cost;
			this.count = count;
		}
		
		@Override
		public int compareTo(Node o) {
			return Long.compare(cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //도시의 수
		M = Integer.parseInt(st.nextToken()); //도로의 수
		K = Integer.parseInt(st.nextToken());
		
		//그래프 초기화
		graph = new ArrayList[N+1];
		dp = new long[N+1][K+1];
		for (int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
			Arrays.fill(dp[i], INF);
		}
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long cost = Long.parseLong(st.nextToken());
			graph[a].add(new Node(b,cost,0));
			graph[b].add(new Node(a,cost,0));
		}
		
		dijkstra();
		long min = INF;
		for (long a : dp[N]) {
			min = Math.min(min, a);
		}
		System.out.println(min);
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,0,0));
		dp[1][0] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.cost > dp[cur.n][cur.count]) continue;
			
			for (Node next : graph[cur.n]) {
				long nextCost = cur.cost + next.cost;
				
				if (nextCost < dp[next.n][cur.count]) {
					dp[next.n][cur.count] = nextCost;
					pq.add(new Node(next.n, nextCost, cur.count));
				}
				
				if (cur.count < K && cur.cost < dp[next.n][cur.count+1]) {
					dp[next.n][cur.count+1] = cur.cost;
					pq.add(new Node(next.n, cur.cost, cur.count+1));
				}
			}
		}
	}

}