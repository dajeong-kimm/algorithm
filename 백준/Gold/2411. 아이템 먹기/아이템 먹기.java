import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static int N, M, A, B;
	
	static boolean[][] disturb;
	
	static class Node implements Comparable<Node> {
		int x, y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Node o) {
			if (y == o.y) {
				return Integer.compare(x,  o.x);
			}
			return Integer.compare(y, o.y);
		}
	}
	
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		for (int i=0;i<A;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(x, y));
		}
		pq.add(new Node(N, M));
		
		disturb = new boolean[N+1][M+1];
		for (int i=0;i<B;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			disturb[x][y] = true;
		}
		
		List<Integer> list = new ArrayList<>(); //각 아이템 사이의 거리
		
		int fromX = 1;
		int fromY = 1;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int toX = cur.x;
			int toY = cur.y;
			
			int cnt = getCount(fromX, fromY, toX, toY);
//			System.out.println("cnt: "+cnt);
			if (cnt == 0) {
				System.out.println(0);
				return;
			}
			list.add(cnt);
			fromX = toX;
			fromY = toY;
		}
		
		int answer = 1;
		for (int num : list) {
			answer *= num;
		}
		System.out.println(answer);
	}
	
	static int getCount(int fromX, int fromY, int toX, int toY) {
		int count = 0;
		
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(fromX, fromY));
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			if (cur.x == toX && cur.y == toY) {
				count++;
			}
			
			for (int d=0;d<2;d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if (nx > toX || ny > toY) continue; //도착지점 절대 못가면
				
				if (disturb[nx][ny]) continue; //장애물이면
				
				q.add(new Node(nx, ny));
			}
		}
		return count;
		
	}

}
