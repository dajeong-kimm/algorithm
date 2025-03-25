import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int curDay;
	static List<Node> list = new ArrayList<>();
	
	static class Node implements Comparable<Node> {
		int from, to, t;
		
		Node(int from, int to, int t) {
			this.from = from;
			this.to = to;
			this.t = t;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(t, o.t);
		}
	}
	
	static int[] parent;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for (int i=1;i<=N;i++) {
			parent[i] = i;
		}
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			list.add(new Node(a, b, t));
		}
		
		Collections.sort(list);
		curDay = 1;
		for (int i=0;i<list.size();i++) {
			Node cur = list.get(i);
			if (cur.t > curDay) break; 
			if (union(cur.from, cur.to)) {
				curDay++;
			}
		}
		System.out.println(curDay);
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
