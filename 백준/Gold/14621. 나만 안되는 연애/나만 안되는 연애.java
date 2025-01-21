import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] isMan; //남자면 1 저장
	static int N, M;
	static int[] parent;
	
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	
	static class Edge implements Comparable<Edge> {
		int from, to, weight;
		
		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for (int i=1;i<=N;i++) {
			parent[i] = i;
		}
		
		isMan = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			String input = st.nextToken();
			if (input.equals("M")) isMan[i] = 1;
		}
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			if (isMan[a] + isMan[b] == 1) {
				pq.add(new Edge(a, b, cost));
			}
		}
		
		if (pq.size() < N-1) {
			System.out.println(-1);
			return;
		}
		
		int answer = 0;
		boolean[] test = new boolean[N+1];
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (union(cur.from, cur.to)) {
				answer += cur.weight;
				test[cur.from] = true;
				test[cur.to] = true;
			}
		}
		
		for (int i=1;i<=N;i++) {
			if (!test[i]) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(answer);
	}
	
	static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if (pa == pb) return false;
		
		parent[pa] = pb;
		return true;
	}

}
