import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] arr;
	static int startX, startY;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					startX = i;
					startY = j;
				}
			}
		}
		
		visited = new int[n][m];
		for (int i=0;i<n;i++) {
			Arrays.fill(visited[i], -1);
		}
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {startX, startY});
		visited[startX][startY] = 0;
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int i=0;i<4;i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if (nx<0 || nx>=n || ny<0 || ny>=m) continue;
				
				if (visited[nx][ny] != -1 || arr[nx][ny] == 0) continue;
				
				visited[nx][ny] = visited[cur[0]][cur[1]]+1;
				q.add(new int[] {nx,ny});
				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				if (arr[i][j] == 0) {
					sb.append(0).append(" ");
					continue;
				}
				sb.append(visited[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
