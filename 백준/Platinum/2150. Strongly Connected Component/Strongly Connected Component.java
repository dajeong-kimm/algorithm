import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int V,E;
	static List<Integer> graph[];
	static boolean[] onStack;
	static int[] ids, low; //방문순서와 low-link값
	static int id = 0; //DFS 탐색 순서 ID
	static Stack<Integer> stack;
	static List<List<Integer>> scc = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[V+1];
		for (int i=0;i<=V;i++) {
			graph[i] = new ArrayList<>();
		}
		
		onStack = new boolean[V+1];
		ids = new int[V+1];
		low = new int[V+1];
		stack = new Stack<>();
		
		for (int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
		}
		
		//모든 정점에 대해 DFS --> SCC찾기
		for (int i=1;i<=V;i++) {
			//아직 방문하지 않은 경우
			if (ids[i] == 0) {
				dfs(i);
			}
		}
		
		scc.sort((a,b) -> Integer.compare(a.get(0), b.get(0)));
		
		StringBuilder sb = new StringBuilder();
		sb.append(scc.size()).append("\n");
		for (List<Integer> component : scc) {
			for (int node : component) {
				sb.append(node).append(" ");
			}
			sb.append("-1\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int at) {
		stack.push(at);
		onStack[at] = true;
		ids[at] = low[at] = ++id; //방문 순서와 low-link값을 현재 id로 설정
		
		for (int to : graph[at]) {
			//아직 방문하지 않은 경우
			if (ids[to] == 0) {
				dfs(to);
				low[at] = Math.min(low[at], low[to]);
			} else if (onStack[to]) {
				low[at] = Math.min(low[at], ids[to]);
			}
		}
		
		if (ids[at] == low[at]) {
			List<Integer> component = new ArrayList<>();
			while (true) {
				int node = stack.pop();
				onStack[node] = false;
				component.add(node);
				if (node == at) break;
			}
			Collections.sort(component);
			scc.add(component);
		}
	}

}
