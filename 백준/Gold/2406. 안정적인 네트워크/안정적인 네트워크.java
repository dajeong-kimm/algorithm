import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] costArr;
	static List<Node> costList = new ArrayList<>();
	static int[] parent;
	
	static long answer = 0;
	static List<int[]> pairList = new ArrayList<>();
	static int cnt = 0;
	
	static class Node implements Comparable<Node>{
		int a, b, cost;
		
		
		Node(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		for (int i=1;i<=n;i++) {
			parent[i] = i;
		}
		
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		costArr = new int[n+1][n+1];
		for (int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1;j<=n;j++) {
				costArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=2;i<=n;i++) {
			for (int j=i+1;j<=n;j++) {
				costList.add(new Node(i, j, costArr[i][j]));
			}
		}
		
		Collections.sort(costList);
		
		for (Node node : costList) {
			if (union(node.a, node.b)) {
				answer += node.cost;
				pairList.add(new int[] {node.a, node.b});
				cnt++;
			}
		}
		
		System.out.println(answer+" "+cnt);
		for (int[] pair : pairList) {
			System.out.println(pair[0]+" "+pair[1]);
		}
		
		
	}
	
	static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if (pa == pb) return false;
		
		if (pa < pb) {
			parent[pb] = pa;
		} else {
			parent[pa] = pb;
		}
		return true;
	}

}
