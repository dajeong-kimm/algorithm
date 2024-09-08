import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 벽 부수고 이동하기 2
 * N*M 행렬
 * 0은 디오할 수 있는 곳 1은 벽
 * (1,1 -> M,M)까지 이동 
 * 최단 경로로 이동
 * 시작하는 칸과 끝나는 칸도 포함해서 센다.
 * 
 * 벽을 K개까지 부수고 이동할 수 있다.
 * @author KOREA
 *
 */
public class Main {
	static int N,M,K;
	static char[][] arr;
	static int answer = -1;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};

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
		//------------------------------------
		bfs();
		System.out.println(answer);

	}
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][K+1];
		q.add(new int[] {0,0,0});
		visited[0][0][0] = true;
		int depth = 1;
		
		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int j=0;j<qSize;j++) {
				int[] cur = q.poll();
				int cur_x = cur[0];
				int cur_y = cur[1];
				int k = cur[2];
				
				if (cur_x == N-1 && cur_y == M-1) {
					answer = depth;
					return;
				}
				
				for (int i=0;i<4;i++) {
					int nx = cur_x + dx[i];
					int ny = cur_y + dy[i];
					
					if (nx<0 || nx>=N || ny<0 || ny>=M) continue;
					
					//이동 가능
					if (arr[nx][ny] == '0') {
						if (visited[nx][ny][k]) continue;
						
						visited[nx][ny][k] = true;
						q.add(new int[] {nx,ny,k});
					}
					
					//이동 불가
					else {
						if (k==K) continue;
						
						if (visited[nx][ny][k+1]) continue;
						
						visited[nx][ny][k+1] = true;
						q.add(new int[] {nx,ny,k+1});
					}
				}
			}
			depth++;
		}
		return;
	}

}