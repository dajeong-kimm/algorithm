import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 달이 차오른다, 가자.
 * 
 * 민식이는 미로속에
 * 미로는 직사각형 모양
 * 여행길을 떠나기 위해 미로를 탈출하려고 함
 * 
 * 빈칸 : 언제나 이동 가능 .
 * 벽 : 절대 이동할 수 없음 # 
 * 열쇠 : 언제나 이동 가능. 이곳에 처음 들어가면 열쇠를 집음 (a,b,c,d,e,f)
 * 문 : 대응하는 열쇠가 있을 때만 이동 가능 (A,B,C,D,E,F,G)
 * 민식이의 현재 위치 : 빈 곳 0
 * 출구 : 민식이가 가야하는 곳 1
 * 
 * 민식이가 미로를 탈출하는데 걸리는 이동 횟수의 최솟값 구하기
 * 미로를 탈출할 수 없으면 -1 출력
 * @author KOREA
 *
 */
public class Main {
	static int N,M;
	static char[][] arr;
	
	static int start_x, start_y;
	static int end_x, end_y;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		for (int i=0;i<N;i++) {
			String tmp = br.readLine();
			for (int j=0;j<M;j++) {
				arr[i][j] = tmp.charAt(j);
				if (arr[i][j] == '0') {
					start_x = i;
					start_y = j;
				}
				else if (arr[i][j] == '1') {
					end_x = i;
					end_y = j;
				}
			}
		}
		//-----------------------------------------------
		System.out.println(bfs());

	}
	// 111111 (1<<6 - 1)
	public static int bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N][M][(int) Math.pow(2, 6)];
		
		//x,y,이동횟수, 열쇠상태
		queue.add(new int[] {start_x, start_y, 0, 0}); 
		visited[start_x][start_y][0] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];
			int moves = cur[2];
			int keys = cur[3];
			
			for (int i=0;i<4;i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				int newKeys = keys;
				
				if (nx>=0 && nx<N && ny>=0 && ny<M) {
					char next = arr[nx][ny];
					
					if (next == '#') continue;
					
					if (next == '1') return moves + 1;
					
					if (next>='a' && next<='f') {
						newKeys |= (1<<next - 'a');
					}
					
					//문인데, 그에 해당하는 열쇠가 없을 경우 
					if (next >='A' && next<='F') {
						if ((newKeys & (1<<(next-'A'))) == 0) continue;
					}
					
					//새로운 위치와 열쇠 상태가 방문한 적이 없는 경우만 추가
					if (!visited[nx][ny][newKeys]) {
						visited[nx][ny][newKeys] = true;
						queue.add(new int[] {nx,ny,moves+1, newKeys});
					}
				}
			}
		}
		return -1;
		
	}

}
