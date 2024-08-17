import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 며칠이 지나면 다 익게 되는지? 그 최소 일수
 * @author KOREA
 *
 */
public class Main {
	static int N,M;
	static int[][] arr;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		
		arr = new int[N][M];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					queue.add(new int[] {i,j});
//					visited[i][j] = true;
				}
			}
		}
		if (isdone()) {
			System.out.println(0);
			return;
		}
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];
			
			for (int i=0;i<4;i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				
				if (nx>=0 && nx<N && ny>=0 && ny<M && arr[nx][ny]==0) {
					arr[nx][ny] = arr[cur_x][cur_y]+1;
					queue.add(new int[] {nx,ny});
				}
			}
			
		}
		
		if (!isdone()) {
			System.out.println(-1);
			return;
		}
		
		int answer = 0;
		for (int i = 0;i<N;i++) {
			for (int j=0;j<M;j++) {
				answer = Math.max(arr[i][j], answer);
			}
		}
		System.out.println(answer-1);
		
		

	}
	private static boolean isdone() {
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				if (arr[i][j]==0) return false;
			}
		}
		return true;
	}

}