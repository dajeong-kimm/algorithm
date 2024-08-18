import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
 * 
 * 며칠이 지나면 토마토들이 모두 익는지, 그 최소일수를 구하기
 * @author KOREA
 *
 */
public class Main {
	static int M,N,H;
	
	static int[][][] arr;
	
	static int[] dx = {1,-1,0,0,0,0};
	static int[] dy = {0,0,1,-1,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	
	static int answer = 0;
	
	static int[][][] visited;
	
	static ArrayDeque<int[]> queue;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][N][M];
		visited = new int[H][N][M];
		queue = new ArrayDeque<>();
		for (int i=0;i<H;i++) {
			for (int j=0;j<N;j++) {
				st = new StringTokenizer(br.readLine());
				for (int k=0;k<M;k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if (arr[i][j][k] == 1) {
						queue.add(new int[] {i,j,k});
						visited[i][j][k] = 1;
					}
				}
			}
		}
		if (mature()) {
			System.out.println(0);
			return;
		}
		answer = 0;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];
			int cur_z = cur[2];
			
			for (int i=0;i<6;i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				int nz = cur_z + dz[i];
				
				if (nx>=0 && nx<H && ny>=0 && ny<N && nz>=0 && nz<M) {
					if (visited[nx][ny][nz] == 0 && arr[nx][ny][nz] == 0) {
						arr[nx][ny][nz] = 1;
						visited[nx][ny][nz] = visited[cur_x][cur_y][cur_z]+1;
						answer = Math.max(visited[nx][ny][nz], answer);
						queue.add(new int[] {nx,ny,nz});
					}
				}
			}
		}
		
		if (!mature()) {
			System.out.println(-1);
		} else {
			System.out.println(answer-1);
		}
	}
	
	private static boolean mature() {
		for (int i=0;i<H;i++) {
			for (int j=0;j<N;j++) {
				for (int k=0;k<M;k++) {
					if (arr[i][j][k] == 0) return false;
				}
			}
		}
		return true;
	}

}