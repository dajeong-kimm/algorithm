import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] canGo;
	static List<Edge> graph[];
	static long[] dist;
	
	static class Edge implements Comparable<Edge> {
		int to;
		long cost;
		
		Edge(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		canGo = new boolean[N];
		graph = new ArrayList[N];
		for (int i=0;i<N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == 0) canGo[i] = true; //true일때만 갈 수 있음
		}
		canGo[N-1] = true; //넥서스는 무조건 갈 수 있다고 치자
//		System.out.println(Arrays.toString(canGo));
		
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (canGo[a] && canGo[b]) {
				graph[a].add(new Edge(b,c));
				graph[b].add(new Edge(a,c));
			}
		}
		
		//첫번째 노드부터 갈 수 없으면 -1
		if (!canGo[0]) {
			System.out.println(-1);
			return;
		}
		
		dist = new long[N];
		for (int i=1;i<N;i++) {
			dist[i] = Long.MAX_VALUE/2;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0));
		boolean[] visited = new boolean[N];
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if (visited[cur.to]) continue;
			visited[cur.to] = true;
			
			if (dist[cur.to] < cur.cost) continue;
			
			for (Edge next : graph[cur.to]) {
				if (canGo[next.to]) {
					if (dist[next.to] > dist[cur.to] + next.cost) {
						dist[next.to] = dist[cur.to] + next.cost;
						pq.add(new Edge(next.to, dist[next.to]));
					}
				}
			}
		}
		
//		System.out.println(Arrays.toString(dist));
		
		if (dist[N-1] == Long.MAX_VALUE/2) {
			System.out.println(-1);
		} else {
			System.out.println(dist[N-1]);
		}
		
		

	}

}
