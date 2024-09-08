import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 벽 부수고 이동하기 3
 * 이동하지 않고 같은 칸에 머물러 있는 경우도 가능 (이 경우 방문한 칸의 개수가 하나 늘어남)
 * 낮 -> 밤 -> 낮 -> 밤 (0낮 1밤)
 * 벽은 낮에만 부술 수 있다.
 * 
 * @author KOREA
 *
 */
public class Main {
	static int N,M,K;
	static char[][] arr;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		for (int i=0;i<N;i++) {
			String input = br.readLine();
			for (int j=0;j<M;j++) {
				arr[i][j] = input.charAt(j);
			}
		}
		//-----------------------------------
		bfs();
		System.out.println(answer);
		
	}
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][K+1];
		queue.add(new int[] {0,0,0,0}); //낮은 0 밤은 1
		visited[0][0][0] = true;
		
		int depth = 1;
		
		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			for (int q=0;q<queueSize;q++) {
				int[] cur = queue.poll();
				int cur_x = cur[0];
				int cur_y = cur[1];
				int k = cur[2];
				int dayNight = cur[3];
				
				
				if (cur_x == N-1 && cur_y == M-1) {
					answer = depth;
					return;
				}
				
				for (int i=0;i<4;i++) {
					int nx = cur_x + dx[i];
					int ny = cur_y + dy[i];
					
					if (nx<0 || nx>=N || ny<0 || ny>=M) continue;
					
					//빈칸이라면
					if (arr[nx][ny] == '0' && !visited[nx][ny][k]) {
						queue.add(new int[] {nx,ny,k,dayNight==0?1:0});
						visited[nx][ny][k] = true;
					}
					
					//벽이라면
					else if (arr[nx][ny]=='1') {
						//낮이라면
						if (k<K && dayNight == 0 && !visited[nx][ny][k+1]) {
							queue.add(new int[] {nx,ny,k+1,1});
							visited[nx][ny][k+1] = true;
						}
						
						//밤이라면
						else if (k<K && dayNight == 1) {
							queue.add(new int[] {cur_x, cur_y, k, 0});
						}
					}
				}
			}
			depth++;
			
		}
	}

}