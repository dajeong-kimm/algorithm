import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 탈옥
 * 
 * 감옥에서 죄수 두명을 탈옥시키기
 * 죄수 두 명이 감옥에 있는 유일한 사람
 * 열어야하는 문의 최소 개수 구하기 (한번열면 계속 열린 상태)
 * 
 * 0-1 BFS : 간선의 가중치가 0또는 1일때 사용
 * --> 특정 노드를 방문했을 때 가중치가 0이라면 먼저 방문하도록 함
 * 문이 없는 격자는 가중치가 0, 문이 있는 격자는 가중치가 1
 * --> 한 점에서부터 모든 격자까지의 최소 가중치 (문을 연 갯수) 구하기
 * 
 * 빈공간은 . 
 * 지나갈 수 없는 벽 *
 * 문 # 
 * 죄수의 위치 $
 * @author KOREA
 *
 */
public class Main {
	static int h,w;
	static int[][] arr;
	
	static int[][] hidden;
	
	static int INF = 1_000_000;
	static int ground = 0;
	static int wall = 1;
	static int door = 2;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static StringBuilder sb = new StringBuilder();
	
	static Point helper;
	static Point p1;
	static Point p2;
	
	static class Point {
		int x,y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			arr = new int[h+2][w+2];
			
			p1 = null;
			p2 = null;
			for (int i=1;i<=h;i++) {
				String tmp = br.readLine();
				for (int j=1;j<=w;j++) {
					char c = tmp.charAt(j-1);
					if (c == '#') {
						arr[i][j] = door;
					} else if (c == '*') {
						arr[i][j] = wall;
					} else if (c == '$') {
						if (p1 == null) p1 = new Point(i,j);
						else p2 = new Point(i,j);
					} else if (c == '.') {
						arr[i][j] = ground;
					}
 				}
			}
			helper = new Point(0,0);
			
			int result = INF;
			
			int[][] helperArr = bfs(helper);
			int[][] p1Arr = bfs(p1);
			int[][] p2Arr = bfs(p2);
			int[][] sumArr = new int[h+2][w+2];
			
			for (int i=0;i<h+2;i++) {
				for (int j=0;j<w+2;j++) {
					sumArr[i][j] = helperArr[i][j] + p1Arr[i][j] + p2Arr[i][j];
					
					if (arr[i][j] == door) {
						sumArr[i][j] -= 2;
					}
					result = Math.min(result, sumArr[i][j]);
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);

	}
	public static int[][] bfs(Point p){
		int[][] result = new int[h+2][w+2];
		for (int i=0;i<h+2;i++) {
			Arrays.fill(result[i], INF);
		}
		
		ArrayDeque<Point> dq = new ArrayDeque<>();
		boolean[][] visited = new boolean[h+2][w+2];
		dq.add(p);
		visited[p.x][p.y] = true;
		result[p.x][p.y] = 0;
		
		while (!dq.isEmpty()){
			Point cur = dq.poll();
			for (int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (nx>=0 && nx<h+2 && ny>=0 && ny<w+2 && !visited[nx][ny]) {
					if (arr[nx][ny] == ground) {
						visited[nx][ny] = true;
						result[nx][ny] = result[cur.x][cur.y];
						dq.addFirst(new Point(nx,ny));
					} else if (arr[nx][ny] == door) {
						visited[nx][ny] = true;
						result[nx][ny] = result[cur.x][cur.y]+1;
						dq.addLast(new Point(nx,ny));
					}
				}
			}
		}
		return result;
	}

}