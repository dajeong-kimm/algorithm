import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static List<Integer>[] graph, reverse;
	static Stack<Integer> stack;
	static boolean[] visited;
	static List<List<Integer>> sccList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			visited = new boolean[N+1];
			reverse = new ArrayList[N+1];
			graph = new ArrayList[N+1];
			for (int i=0;i<=N;i++) {
				graph[i] = new ArrayList<>();
				reverse[i] = new ArrayList<>();
			}
			
			stack = new Stack<>(); //dfs 결과 저장
			
			
			for (int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph[from].add(to);
				reverse[to].add(from);
			}
			
			//scc 찾기
			for (int i=1;i<=N;i++) {
				if (!visited[i]) dfs(i);
			}
			
			visited = new boolean[N+1];
			
			sccList = new ArrayList<>();
			//역방향 그래프에서 scc 추출
			while (!stack.isEmpty()) {
				int node = stack.pop();
				
				if (!visited[node]) {
					List<Integer> scc = new ArrayList<>();
					reverseDfs(node, scc);
					sccList.add(scc);
				}
			}
			
			int[] sccId = new int[N+1];
			int sccIdx = 0;
			
			for (List<Integer> scc : sccList) {
				for (int node: scc) {
					sccId[node] = sccIdx;
				}
				sccIdx++;
			}
			
			int[] inDegree = new int[sccIdx];
			for (int i=1;i<=N;i++) {
				for (int next : graph[i]) {
					if (sccId[i] != sccId[next]) {
						inDegree[sccId[next]]++;
					}
				}
			}
			
			int answer = 0;
			for (int i=0;i<sccIdx;i++) {
				if (inDegree[i] == 0) answer++;
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);

	}
	
	static void dfs(int node) {
		visited[node] = true;
		
		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
		
		stack.push(node); //종료 순서대로 스택에 추가
		
	}
	
	static void reverseDfs(int node, List<Integer> scc) {
		visited[node] = true;
		scc.add(node);
		
		for (int next : reverse[node]) {
			if (!visited[next]) {
				reverseDfs(next, scc);
			}
		}
	}

}