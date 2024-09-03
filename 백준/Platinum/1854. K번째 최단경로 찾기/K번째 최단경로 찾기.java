import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * K번째 최단경로 찾기
 * 
 *현재 노드에 해당하는 우선순위 큐 배열에 k개보다 작은 최단 거리만 저장되어 있다면
 *--> 다익스트라 알고리즘으로 발견한 새로운 경로를 저장
 *(우선순위 큐에 의해 자동으로 정렬)
 *
 *우선순위 큐 배열의 size가 k이면 top이 k번째 최단거리 ,, 
 *size가 k가 아니면 k번째 최단거리는 존재하지 않음
 * @author KOREA
 *
 */
public class Main {
	static int n,m,k;
	static ArrayList<Node>[] graph;
	
	public static class Node implements Comparable<Node>{
		int n;
		int cost;
		
		Node(int n, int cost){
			this.n = n;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //도시들의 개수
		m = Integer.parseInt(st.nextToken()); //도로의 수
		k = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		for (int i=0;i<=n;i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b,cost));
		}
		
		//각 노드까지의 경로 길이를 저장할 우선순위 큐 배열
		PriorityQueue<Integer>[] pq = new PriorityQueue[n+1];
		
		Comparator<Integer> cp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1<o2 ? 1 : -1; //내림차순 정렬
			}
		};
		
		for (int i=0;i<=n;i++) {
			pq[i] = new PriorityQueue<>(k,cp); //초기용량을 k로 설정
		}
		
		//다익스트라를 위한 최소힙 선언
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(1,0));
		pq[1].add(0);
		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			
			for (Node next : graph[cur.n]) {
				//연결된 노드까지의 최단 경로 수가 k보다 적다면 추가
				if (pq[next.n].size() < k) {
					pq[next.n].add(cur.cost + next.cost);
					queue.add(new Node(next.n, cur.cost + next.cost));
				}
				//이미 k개의 경로가 있지만, 연결된 경로가 가장 큰 값보다 작으면 갱신
				else if (pq[next.n].peek() > next.cost + cur.cost) {
					pq[next.n].poll();
					pq[next.n].add(next.cost + cur.cost);
					queue.add(new Node(next.n, cur.cost + next.cost));
				}
			}
		}
		
		for (int i=1;i<=n;i++) {
			if (pq[i].size() == k) {
				System.out.println(pq[i].peek());
			}
			else {
				System.out.println(-1 );
			}
		}

	}

}