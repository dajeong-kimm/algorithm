import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] A;
	static long curSum = 0;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	static class Node implements Comparable<Node> {
		int order, num;
		
		Node(int order, int num) {
			this.order = order;
			this.num = num;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(o.num, num);
		}
		
	}
	
	//자식 넣기
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		List<Integer> list[] = new ArrayList[N+1];
		for (int i=0;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=2;i<=N;i++) {
			int parent = Integer.parseInt(st.nextToken());
			list[parent].add(i);
		}
		
		A = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		//루트 먼저 넣기
		sb.append(A[1]).append("\n");
		curSum += A[1];
		for (int next : list[1]) {
			pq.add(new Node(next, A[next]));
		}
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			curSum += cur.num;
			sb.append(curSum).append("\n");
			for (int next : list[cur.order]) {
				pq.add(new Node(next, A[next]));
			}
		}
		System.out.println(sb);
		
	}

}
