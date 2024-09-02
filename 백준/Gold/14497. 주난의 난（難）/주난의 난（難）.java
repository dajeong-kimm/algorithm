import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 주난의 난
 * 주난이에게 최소 점프 횟수 알려주기
 * @author KOREA
 *
 */
public class Main {
	static int N,M;
	static int x1,y1,x2,y2;
	
	static char[][] arr;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static int answer;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N+1][M+1];
		
		st = new StringTokenizer(br.readLine());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		
		for (int i=1;i<=N;i++) {
			String tmp = br.readLine();
			for (int j=1;j<=M;j++) {
				arr[i][j] = tmp.charAt(j-1);
			}
		}
		
		bfs();
		System.out.println(answer);

	}
	public static void bfs() {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x1,y1,0});
		boolean[][] visited = new boolean[N+1][M+1];
		visited[x1][y1] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];
			
			if (cur_x == x2 && cur_y == y2) {
				answer = cur[2];
				return;
			}
			
			for (int i=0;i<4;i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				
				if (nx<1 || nx>N || ny<1 || ny>M || visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				if (arr[nx][ny] == '0') {
					queue.addFirst(new int[] {nx,ny,cur[2]});
				} else {
					queue.addLast(new int[] {nx,ny,cur[2]+1});
				}
			}
		}
		
	}
	static void printArr() {
		for (int i=1;i<=N;i++) {
			for (int j=1;j<=M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}