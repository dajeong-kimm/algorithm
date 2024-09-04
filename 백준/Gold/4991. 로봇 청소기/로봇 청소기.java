import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 로봇 청소기
 * 
 * 직사각형의 방을 청소
 * 유저가 직접 경로를 설정 가능
 * 더러운칸 -> 깨끗한칸
 * 일부 칸에는 가구 ,, 이동할 수 없음
 * 같은 칸을 여러번 방문할 수 있음
 * 
 * 더러운 칸의 개수는 10개를 넘지 않으며 로봇 청소기의 개수는 항상 하나
 * 방문할 수 없는 더러운 칸이 존재하면 -1 출력
 * 
 * 더러운 칸을 모두 깨끗한 칸으로 만드는데 필요한 이동 횟수의 최솟값
 * . 깨끗한 칸
 * * 더러운 칸
 * x 가구
 * o 로봇 청소기의 시작 위치
 * 
 * tsp랑 비슷하게 풀이 ,, 더러운 칸이 10개 이하임므로 완전탐색 가능
 * @author KOREA
 *
 */
public class Main {
	static int w,h;
	
	static int start_x, start_y;
	
	static char[][] arr;
	static int[][] dist; //더러운 칸들 사이의 최소 거리 탐색
	static ArrayList<int[]> dirtyPos;
	
	static int INF = Integer.MAX_VALUE;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w==0 && h==0) break;
			
			arr = new char[h][w];
			dirtyPos = new ArrayList<>();
			for (int i=0;i<h;i++) {
				String tmp = br.readLine();
				for (int j=0;j<w;j++) {
					char c = tmp.charAt(j);
					if (c == 'o') {
						start_x = i;
						start_y = j;
					}
					else if (c =='*') {
						dirtyPos.add(new int[] {i,j});
					}
					arr[i][j] = c;
				}
			}
			//----------------------------------------
			dirtyPos.add(0, new int[] {start_x, start_y});
			int dirtyCount = dirtyPos.size();
			dist = new int[dirtyCount][dirtyCount];
			
			//더러운 칸들 사이의 최소 거리 계산
			boolean flag = false;
			for (int i=0;i<dirtyCount;i++) {
				int[] start = dirtyPos.get(i);
				if (!bfs(start[0], start[1], i, dirtyCount)) {
					//갈 수 없는 더러운 칸이 있는 경우
					System.out.println(-1);
					flag = true;
					break;
				}
			}
			
			if (!flag) {
				//모든 더러운 칸을 방문하는 최소 경로 계산
				int answer = tsp(1,0,dirtyCount,new int[dirtyCount][1<<dirtyCount]);
				System.out.println(answer);
			}
			
		}

	}
	
	static boolean bfs(int startX, int startY, int idx, int dirtyCount) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[h][w];
		queue.add(new int[] {startX, startY, 0}); //x,y,distance
		visited[startX][startY] = true;
		
		int foundCnt = 0;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			int distance = cur[2];
			
			//현재 위치가 더러운 칸이면 거리를 저장
			for (int i=0;i<dirtyCount;i++) {
				if (dirtyPos.get(i)[0] == x && dirtyPos.get(i)[1] == y) {
					dist[idx][i] = distance;
					foundCnt++;
				}
			}
			
			if (foundCnt == dirtyCount) return true;
			
			for (int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx>=0 && nx<h && ny>=0 && ny<w && !visited[nx][ny] && arr[nx][ny] != 'x') {
					visited[nx][ny] = true;
					queue.add(new int[] {nx,ny,distance+1});
				}
			}
		}
		
		return false;
	}
	
	//모든 더러운 칸을 방문하는 최소 이동 횟수 계산
	static int tsp(int visited, int cur, int dirtyCount, int[][] dp) {
		if (visited == (1<<dirtyCount)-1) return 0;
		
		if (dp[cur][visited] != 0) return dp[cur][visited];
		
		int result = INF;
		
		for (int next = 0; next<dirtyCount; next++) {
			if ((visited & (1<<next)) == 0) {
				//방문하지 않은 칸만 방문
				
				result = Math.min(result, dist[cur][next] + tsp(visited | (1<<next), next, dirtyCount, dp));
			}
		}
		return dp[cur][visited] = result;
	}

}