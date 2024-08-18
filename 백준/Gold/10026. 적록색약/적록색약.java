import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 적록색약 : 빨간색 초록색 차이 느끼지 못함
 * 
 * 적록색약인 사람
 * 아닌 사람 봤을 때 각각 구역의 수 구하기
 * @author KOREA
 *
 */
public class Main {
	static int N;
	static int[][] arr;
	
	static int answer1;
	static int answer2;
	
	static boolean[][] visited;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i=0;i<N;i++) {
			String input = br.readLine();
			for (int j=0;j<N;j++) {
				char tmp = input.charAt(j);
				if (tmp=='R') arr[i][j] = 1;
				else if (tmp=='G') arr[i][j] = 2;
				else arr[i][j] = 10;
			}
		}
		
		visited = new boolean[N][N];
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				if (!visited[i][j]) {
					answer1++;
					BFS(i,j,arr[i][j],true);
				}
			}
		}
		
		visited = new boolean[N][N];
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				if (!visited[i][j]) {
					answer2++;
					BFS(i,j,arr[i][j],false);
				}
			}
		}
		
		System.out.print(answer2+" "+answer1);
		
	}
	//true면 적록색약
	private static void BFS(int x, int y, int color,boolean flag) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x,y});
		visited[x][y] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];
			
			for (int i=0;i<4;i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				
				if (nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
					//색약인 경우
					if (flag) {
						if (Math.abs(color-arr[nx][ny])<=1) {
							visited[nx][ny] = true;
							queue.add(new int[] {nx,ny});
						}
					}
					//색약이 아닌 경우
					else {
						if (color == arr[nx][ny]) {
							visited[nx][ny] = true;
							queue.add(new int[] {nx,ny});
						}
					}
				}
			}
		}
	}

}