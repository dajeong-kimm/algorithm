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
	static int dist = Integer.MAX_VALUE;
	static int small, big;
	
	static List<Integer> graph[];
	static int N, M;
	
	static int tmpDist;

	public static void main(String[] args) throws IOException{
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
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		//작은 수는 작은것부터, 큰 수는 큰 수부터 조합
		for (int i=1;i<N;i++) {
			for (int j=N;j>i;j--) {
				tmpDist = 0;
				bfs(i, j);
				
				if (tmpDist < dist) {
					dist = tmpDist;
					small = i;
					big = j;
				}
			}
		}
		
		System.out.println(small+" "+big+" "+dist);
	}
	
	static void bfs(int i, int j) {
		Queue<Integer> q = new ArrayDeque<>();
		int[] visited = new int[N+1];
		Arrays.fill(visited, -1);
		visited[i] = 0;
		visited[j] = 0;
		
		q.add(i);
		q.add(j);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next : graph[cur]) {
				if (visited[next] == -1) {
					visited[next] = visited[cur]+1;
					q.add(next);
				}
			}
		}
		
		for (int x=1;x<=N;x++) {
			tmpDist += visited[x];
		}
		tmpDist *= 2;
		
	}

}