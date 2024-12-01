import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] inDegree = new int[N+1];
		List<Integer> graph[] = new ArrayList[N+1];
		for (int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			inDegree[b]++;
		}
		
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new ArrayDeque<>();
		for (int i=1;i<=N;i++) {
			if (inDegree[i] == 0) q.add(i);
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for (int next : graph[cur]) {
				inDegree[next]--;
				if (inDegree[next] == 0) q.add(next);
			}
		}
		
		System.out.println(sb);

	}

}
