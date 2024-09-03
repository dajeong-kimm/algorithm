import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 거의 최단 경로
 * 
 * 최단 경로에 포함되지 않는 도로로만 이루어진 경로 중 가장 짧은 것
 * 
 * 1. 첫번째 다익스트라 : 각각의 노드에 대해 최소 경로가 되는 직전 노드를 찾아서 parent[n]에 넣기
 * 2. parent[n]을 통해 D에서부터 시작하여 최소 경로를 백트래킹
 * --> check[u][v]=true인 간선은 두번째 다익스트라에서 사용할 수 없음
 * @author KOREA
 *
 */
public class Main {
	static int N,M;
	static int S,D;
	
	static boolean[][] check;
	static ArrayList<Node> arr[];
	static ArrayList<Integer>[] parent;
	static int[] dist;
	
	static class Node implements Comparable<Node>{
		int n;
		int cost;
		Node(int n, int cost){
			this.n = n;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(cost,  o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if (N==0 && M == 0) break;
			
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			
			dist = new int[N];
			check = new boolean[N][N];
			
			//graph 초기화
			parent = new ArrayList[N];
			arr = new ArrayList[N];
			for (int i=0;i<N;i++) {
				parent[i] = new ArrayList<>();
				arr[i] = new ArrayList<>();
			}
			
			for (int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				arr[a].add(new Node(b,cost));
			}
			
			//첫번째 다익스트라
			dijkstra(S,D);
			
			//백트랙킹
			backTracking(S,D);
			
			//두번째 다익스트라
			dijkstra(S,D);
			
			if (dist[D] == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(dist[D]);
			}
			
		}

	}
	public static void backTracking(int S, int node) {
		if (node == S) return;
		
		for (int n : parent[node]) {
			if (!check[n][node]) {
				check[n][node] = true;
				backTracking(S,n);
			}
		}
	}
	
	public static void dijkstra(int S, int D) {
		for (int i=0;i<N;i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[S] = 0;
		pq.add(new Node(S,dist[S]));
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (dist[cur.n] < cur.cost) continue;
			
			for (Node next : arr[cur.n]) {
				if (!check[cur.n][next.n]) {
					if (dist[next.n] == dist[cur.n] + next.cost) {
						parent[next.n].add(cur.n);
					}
					else if (dist[next.n] > dist[cur.n] + next.cost) {
						dist[next.n] = dist[cur.n] + next.cost;
						parent[next.n].clear();
						parent[next.n].add(cur.n);
						pq.add(new Node(next.n, dist[next.n]));
					}
				}
			}
		}
	}

}
