import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map.put(from,  to);
		}
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map.put(from,  to);
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[101];
		q.add(1);
		visited[1] = true;
		
		int depth = 0;
		outer:
		while (!q.isEmpty()) {
			int qSize = q.size();
			
			for (int cnt=0;cnt<qSize;cnt++) {
				int cur = q.poll();
				
				if (cur == 100) break outer;
				
				for (int i=1;i<=6;i++) {
					if ((cur+i) <= 100 && !visited[cur+i]) {
						int to = cur+i;
						visited[cur+i] = true;
						if (map.containsKey(cur+i)) {
							visited[map.get(to)] = true;
							to = map.get(to);
						}
						q.add(to);
					}
				}
			}
			
			depth++;
		}
		
		System.out.println(depth);
	}

}
