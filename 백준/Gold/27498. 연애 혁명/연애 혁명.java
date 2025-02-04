import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] parent;
	
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	static class Node implements Comparable<Node> {
		int a, b;
		int cost;
		
		Node(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(o.cost, cost);
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
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			//이미 성사된 관계
			if (d == 1) {
				union(a, b);
			}
			else {
				pq.add(new Node(a, b, c));
			}
		}
		
		int answer = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (!union(cur.a, cur.b)) answer += cur.cost;
		}
		System.out.println(answer);
		
		

	}
	
	static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if (pa != pb) {
			parent[pa] = pb;
			return true;
		}
		return false;
	}

}
