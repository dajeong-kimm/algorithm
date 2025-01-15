import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<Node> graph[];
	static int[] before;
	static int[] dist;
	
	static class Node implements Comparable<Node> {
		int to;
		int weight;
		
		Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(weight,  o.weight);
		}
	}

	//0에서 M-1 만날 수 있으면 만난 순서대로 출력
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //관계
			M = Integer.parseInt(st.nextToken()); //정치인의 수
			
			graph = new ArrayList[M];
			for (int i=0;i<M;i++) {
				graph[i] = new ArrayList<>();
			}
			
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				graph[a].add(new Node(b, c));
				graph[b].add(new Node(a, c));
			}
			
			dist = new int[M];
			Arrays.fill(dist, Integer.MAX_VALUE/2);
			dist[0] = 0; //자기 자신까지의 거리는 0
			
			before = new int[M];
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0));
			
			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				
				for (Node next : graph[cur.to]) {
					int nextWeight = dist[cur.to] + next.weight;
					
					//이 노드를 지나는 것이 더 비용이 크면 skip
					if (nextWeight > dist[next.to]) continue;
					
					dist[next.to] = nextWeight;
					before[next.to] = cur.to; //다음번에 방문하는 번호 저장
					pq.add(next);

				}
			}
//			System.out.println(Arrays.toString(dist));
//			System.out.println(Arrays.toString(before));
			
			sb.append("Case #").append(t).append(": ");
			
			//M-1을 방문할 수 없는 경우
			if (dist[M-1] == Integer.MAX_VALUE/2) {
				sb.append(-1);
			}
			else {
				List<Integer> list = new ArrayList<>();
				int cur = M-1;
				while (true) {
					list.add(cur);
					if (cur == 0) break;
					cur = before[cur];
				}
				
				for (int i=list.size()-1;i>=0;i--) {
					sb.append(list.get(i)).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
