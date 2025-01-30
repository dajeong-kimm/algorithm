import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int W, H;
	static char[][] map;
	static int startX, startY, endX, endY;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		startX = -1;
		startY = -1;
		for (int i=0;i<H;i++) {
			String input = br.readLine();
			for (int j=0;j<W;j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'C') {
					if (startX == -1 && startY == -1) {
						startX = i;
						startY = j;
					}
					else {
						endX = i;
						endY = j;
					}
				}
			}
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[][][] visited = new int[H][W][4];
		for (int i=0;i<H;i++) {
			for (int j=0;j<W;j++) {
				Arrays.fill(visited[i][j], Integer.MAX_VALUE/2);
			}
		}
//		boolean[][] visited = new boolean[H][W];
		visited[startX][startY][0] = 0;
		visited[startX][startY][1] = 0;
		visited[startX][startY][2] = 0;
		visited[startX][startY][3] = 0;
		//시작점은 그냥 사방 탐색
		for (int i=0;i<4;i++) {
			int nx = startX + dx[i];
			int ny = startY + dy[i];
			
			//한칸만에 도착점을 만나버리면
			if (nx == endX && ny == endY) {
				System.out.println(0);
				return;
			}
			
			if (nx>=0 && nx<H && ny>=0 && ny<W && map[nx][ny] != '*') {
				pq.add(new Node(nx, ny, i, 0));
				visited[nx][ny][i] = 0;
			}
		}
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (cur.x == endX && cur.y == endY) {
				System.out.println(cur.cnt);
				return;
			}
			
			int nx, ny;
			//이전방향과 같은 곳 먼저 탐색
			nx = cur.x + dx[cur.beforeDir];
			ny = cur.y + dy[cur.beforeDir];
			
			
			if (nx>=0 && nx<H && ny>=0 && ny<W && visited[nx][ny][cur.beforeDir] > cur.cnt && map[nx][ny] != '*') {
				visited[nx][ny][cur.beforeDir] = cur.cnt;
				pq.add(new Node(nx, ny, cur.beforeDir, cur.cnt));
			}
			
			//이전방향과 다른 곳 탐색
			for (int i=0;i<4;i++) {
				if (i == cur.beforeDir) continue;
				
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];
				if (nx>=0 && nx<H && ny>=0 && ny<W && visited[nx][ny][i] > (cur.cnt+1) && map[nx][ny] != '*') {
					visited[nx][ny][i] = cur.cnt + 1;
					pq.add(new Node(nx, ny, i, cur.cnt + 1));
				}
			}
			
		}
		
		System.out.println(visited[endX][endY]);
		
		
	}
	
	static class Node implements Comparable<Node>{
		int x, y;
		int beforeDir; //이전방향
		int cnt; //거울개수
		
		Node(int x, int y, int beforeDir, int cnt) {
			this.x = x;
			this.y = y;
			this.beforeDir = beforeDir;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(cnt,  o.cnt);
		}
	}
	
	

}