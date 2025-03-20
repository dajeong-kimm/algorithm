import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[] visited;
	static List<Integer> graph[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		int testCase = 1;
		
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0) break;
			
			graph = new ArrayList[n+1];
			for (int i=0;i<=n;i++) {
				graph[i] = new ArrayList<>();
			}
			sb.append("Case ").append(testCase++).append(": ");
			
			for (int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}
			
			visited = new boolean[n+1];
			
			int answer = 0;
			for (int i=1;i<=n;i++) {
				if (!visited[i]) {
					boolean flag = false; //사이클이 생겼는지 
					Queue<int[]> q = new ArrayDeque<>();
					visited[i] = true;
					q.add(new int[] {i,i});
					A: while (!q.isEmpty()) {
						int[] arr = q.poll();
						int cur = arr[0];
						int before = arr[1];
						
						for (int next : graph[cur]) {
							if (next == before) continue;
							if (visited[next]) {
								flag = true;
								break A;
							}
							visited[next] = true;
							q.add(new int[] {next, cur});
						}
					}
					
					if (!flag) answer++;
				}
			}
			
			if (answer == 0) {
				sb.append("No trees.").append("\n");
			} else if (answer == 1) {
				sb.append("There is one tree.").append("\n");
			} else {
				sb.append("A forest of ").append(answer).append(" trees.").append("\n");
			}
			
		}
		System.out.println(sb);
		
	}

}
