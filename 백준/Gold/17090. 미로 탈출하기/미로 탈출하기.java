import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
//	static boolean[][] visited;
	static Set<Integer> visited;
	static int[][] mark;
	
	//U D R L
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for (int i=0;i<N;i++) {
			String input = br.readLine();
			for (int j=0;j<M;j++) {
				char ch = input.charAt(j);
				if (ch == 'D') arr[i][j] = 1;
				else if (ch == 'R') arr[i][j] = 2;
				else if (ch == 'L') arr[i][j] = 3;
			}
		}
		
		//0 방문안함 1 가능 2 불가능
		mark = new int[N][M];
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				if (mark[i][j] == 0) {
					visited = new HashSet<>();
					visited.add(i*M + j);
					int curX = i;
					int curY = j;
					while (true) {
						int d = arr[curX][curY];
						
						int nx = curX + dx[d];
						int ny = curY + dy[d];
						
						//탈출 성공
						if (nx < 0 || nx >= N || ny<0 || ny >= M) {
							for (int visit : visited) {
								int x = visit / M;
								int y = visit % M;
								mark[x][y] = 1;
							}
							break;
						}
						else {
							if (mark[nx][ny] ==0 && !visited.contains(nx*M + ny)) {
								visited.add(nx*M + ny);
								curX = nx;
								curY = ny;
							}
							else if (mark[nx][ny] == 1) {
								for (int visit : visited) {
									int x = visit / M;
									int y = visit % M;
									mark[x][y] = 1;
								}
								break;
							}
							else {
								for (int visit : visited) {
									int x = visit / M;
									int y = visit % M;
									mark[x][y] = 2;
								}

								break;
							}
						}
					}
				}
			}
		}
		
		int answer = 0;
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				if (mark[i][j] == 1) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);

	}
	


}