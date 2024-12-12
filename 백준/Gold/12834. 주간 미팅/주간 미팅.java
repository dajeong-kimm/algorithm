import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, V, E;
	
	static class Edge implements Comparable<Edge>{
		int num;
		int weight;
		
		Edge(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}
		
	}
	
	static List<Edge> graph[];
	static int A, B;
	static int[] home;
	
	static final int MAX = Integer.MAX_VALUE/2;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[V+1];
		for (int i=0;i<=V;i++) {
			graph[i] = new ArrayList<>();
		}
		
		home = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			home[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Edge(b, c));
			graph[b].add(new Edge(a, c));
		}
		
		long answer = 0;
		
		for (int i=0;i<N;i++) {
			int h = home[i];
			int[] dist = minDist(h);
//			System.out.println(Arrays.toString(dist));
			int a = (dist[A] == MAX) ? -1 : dist[A];
			int b = (dist[B] == MAX) ? -1 : dist[B];
//			System.out.println("a: "+a+" b: "+b);
			answer += (a+b);
		}
		
		System.out.println(answer);
	}
	
	static int[] minDist(int start) {
		int[] dist = new int[V+1];
		Arrays.fill(dist, MAX);
		dist[start] = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {start, 0});
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0];
			int curW = cur[1];
			
			if (curW > dist[curX]) continue;
			
			for (Edge next : graph[curX]) {
				if (dist[next.num] > dist[curX] + next.weight) {
					dist[next.num] = dist[curX] + next.weight;
					q.add(new int[] {next.num, dist[next.num]});
				}
			}
		}
		return dist;
		
	}

}
