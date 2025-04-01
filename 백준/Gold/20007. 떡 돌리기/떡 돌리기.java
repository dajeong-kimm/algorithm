import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 다음 집 갔다가 집에 다시 돌아올 수 있을 때만 GO
 * @author KOREA
 *
 */
public class Main {
	static int[] dist;
	static int N, M, X, Y;
	
	static class Road implements Comparable<Road> {
		int to;
		int cost;
		
		Road(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Road o) {
			return Integer.compare(o.cost, cost);
		}
	}
	
	static PriorityQueue<Road> pqArr[];
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		dist = new int[N];
		pqArr = new PriorityQueue[N];
		for (int i=0;i<N;i++) {
			pqArr[i] = new PriorityQueue<>();
		}
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pqArr[a].add(new Road(b,c));
			pqArr[b].add(new Road(a,c));
		}
		
		visited = new boolean[N];
		Arrays.fill(dist, Integer.MAX_VALUE/2);
		dist[Y] = 0;
		visited[Y] = true;
		PriorityQueue<Road> pq = new PriorityQueue<>();
		pq.add(new Road(Y, 0));
		
		
		while (!pq.isEmpty()) {
			Road cur = pq.poll();
			
			if (dist[cur.to] < cur.cost) continue;
			
			for (Road next : pqArr[cur.to]) {
				
				if (dist[next.to] > cur.cost + next.cost) {
					dist[next.to] = cur.cost + next.cost;
					pq.add(new Road(next.to, dist[next.to]));
					visited[next.to] = true;
				}
			}
		}
		
		pq = new PriorityQueue<>();
		for (int i=0;i<N;i++) {
			if (i != Y) pq.add(new Road(i, dist[i]));
		}
		
		int curDay = 1;
		int curWalk = 0;
		while (!pq.isEmpty()) {
			Road cur = pq.poll();
			if (cur.cost*2 > X) {
				System.out.println(-1);
				return;
			}
			if (curWalk + (cur.cost*2) > X) {
				curDay++;
				curWalk = cur.cost*2;
			} else {
				curWalk += cur.cost*2;
			}
		}
		System.out.println(curDay);
		
		
		
	}

}
