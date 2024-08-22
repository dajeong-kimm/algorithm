import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * N개의 집 ,,, 그 집들을 연결하는 M개의 길
 * 임의의 두 집 사이에 경로가 항상 존재
 * 
 * 마을을 두 개의 분리된 마을로 분할할 계획
 * 각 분리된 마을 안에 집들이 서로 연결되도록 분할
 * 마을에는 집이 하나 이상 있어야 함
 * 
 * 분리된 두 마을 사이에 있는 길들은 필요가 없으므로 없앨 수 있음
 * 
 * 나머지 길의 유지비의 합을 최소로 하고싶다.
 * 
 * 크루스칼로 만들고 마지막 cost 하나 빼기
 * @author KOREA
 *
 * 
 */
public class Main {
	static int N,M;
	
	static PriorityQueue<Edge> queue;
	
	static int[] parent;
	
	public static class Edge implements Comparable<Edge> {
		int a;
		int b;
		int cost;
		
		Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			return cost - e.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		queue = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for (int i=1;i<=N;i++) {
			parent[i] = i;
		}
		
		long answer = 0;
		int last_cost = 0;
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			queue.add(new Edge(a, b, cost));
		}
		
		while (!queue.isEmpty()) {
			Edge e = queue.poll();
			if (find(e.a) != find(e.b)) {
				answer += e.cost;
				last_cost = e.cost;
				union(e.a, e.b);
			}
//			System.out.println(Arrays.toString(parent));
//			int x = find(1);
//			boolean flag = true;
//			for (int i=2;i<=N;i++) {
//				if (x != find(i)) {
//					flag = false;
//					break;
//				}
//			}
//			if (flag) break;
		}
		System.out.println(answer-last_cost);

	}
	
	public static void union(int a, int b) {
		int parent_a = find(a);
		int parent_b = find(b);
		
		if (parent_a != parent_b) {
			if (parent_a < parent_b) {
				parent[parent_b] = parent_a;
			}else {
				parent[parent_a] = parent_b;
			}
		}
	}
	public static int find(int x) {
		if (parent[x] == x) return x;
		
		return parent[x] = find(parent[x]);
	}

}