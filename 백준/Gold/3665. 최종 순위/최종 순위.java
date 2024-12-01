import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			int[] inDegree = new int[n+1];
			int[] lastYear = new int[n+1];
			
			List<Integer> graph[] = new ArrayList[n+1];
			for (int i=0;i<=n;i++) {
				graph[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i=1;i<=n;i++) {
				lastYear[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i=1;i<=n;i++) {
				int from = lastYear[i];
				for (int j=i+1;j<=n;j++) {
					int to = lastYear[j];
					
					inDegree[to]++;
					graph[from].add(to);
				}
			}
			
			//순서 바꾸기
			int m = Integer.parseInt(br.readLine());
			for (int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (graph[a].contains(b)) {
					inDegree[b]--;
					inDegree[a]++;
					graph[a].remove((Integer)b);
					graph[b].add(a);
				}
				else {
					inDegree[a]--;
					inDegree[b]++;
					graph[b].remove((Integer)a);
					graph[a].add(b);
				}
			}
			
			//inDegree가 0인거 큐에 추가
			Queue<Integer> q = new ArrayDeque<>();
			for (int i=1;i<=n;i++) {
				if (inDegree[i] == 0) q.add(i);
			}
			
			StringBuilder sb = new StringBuilder();
			
			//큐에 1개 이상 있으면 순위를 결정하기 모호한 상황
			if (q.size() > 1) {
				System.out.println("?");
				continue;
			}
			
			//n개의 팀의 순서를 정해야함
			boolean flag = false;
			for (int i=1;i<=n;i++) {
				if (q.isEmpty()) {
					System.out.println("IMPOSSIBLE");
					flag = true;
					break;
				}
				
				int from = q.poll();
				sb.append(from).append(" ");
				for (int next : graph[from]) {
					inDegree[next]--;
					if (inDegree[next] == 0) q.add(next);
				}
				
			}
			
			if (!flag) System.out.println(sb);
		}

	}

}