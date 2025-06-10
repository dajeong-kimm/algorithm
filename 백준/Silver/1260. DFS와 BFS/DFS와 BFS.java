import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, V;
	static boolean[] visited;
	static List<Integer> graph[];
	
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for (int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for (int i=0;i<=N;i++) {
			Collections.sort(graph[i]);
		}
		
		//DFS
		sb = new StringBuilder();
		visited = new boolean[N+1];
		dfs(V);
		System.out.println(sb);
		
		//BFS
		sb = new StringBuilder();
		visited = new boolean[N+1];
		bfs(V);
		System.out.println(sb);
	}
	
	static void bfs(int x) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[x] = true;
		q.add(x);
		sb.append(x).append(" ");
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next : graph[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					sb.append(next).append(" ");
					q.add(next);
				}
			}
		}
	}
	
	static void dfs(int x) {
		sb.append(x).append(" ");
		visited[x] = true;
		
		for (int next : graph[x]) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(next);
			}
		}
	}

}
