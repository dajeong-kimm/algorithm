import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> graph[] = new ArrayList[N+1];
		for (int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		int[] time = new int[N+1];
		int[] inDegree = new int[N+1];
		int[] finishTime = new int[N+1];
		
		for (int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			time[i] = t;
			
			int cnt = Integer.parseInt(st.nextToken());
			for (int j=0;j<cnt;j++) {
				int to = Integer.parseInt(st.nextToken());
				inDegree[to]++;
				graph[i].add(to);
			}
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for (int i=1;i<=N;i++) {
			if (inDegree[i] == 0) {
				q.add(i);
				finishTime[i] = time[i];
			}
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next : graph[cur]) {
				inDegree[next]--;
				finishTime[next] = Math.max(finishTime[next], finishTime[cur] + time[next]);
				if (inDegree[next] == 0) q.add(next);
			}
		}
		
		for (int i=1;i<=N;i++) {
			answer = Math.max(answer, finishTime[i]);
		}
		
		System.out.println(answer);
	}

}