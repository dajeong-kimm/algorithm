import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<Integer> graph[];
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for (int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
		}
		
		int S = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<S;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		int cnt = 0;
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		
		//출발지에 팬클럽이 있으면 무조건 만남
		if (set.contains(1)) {
			System.out.println("Yes");
			return;
		}
		
		while (!q.isEmpty()) {
			int cur = q.poll();
//			System.out.println(cur);
			
			if (graph[cur].size() == 0) {
				System.out.println("yes");
				return;
			}
			
			boolean flag = false;
			for (int next : graph[cur]) {
				if (!set.contains(next)) {
					flag = true;
					q.add(next);
				}
			}
			
		}
		
		System.out.println("Yes");
	}

}