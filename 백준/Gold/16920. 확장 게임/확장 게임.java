import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 확장 게임
 * 
 * N*M 격자판 위에서 진행
 * 각 칸은 비어있거나 막혀있음
 * 
 * 각 플레이어는 하나 이상의 성을 가지고 있음, 각 칸에는 성이 하나
 * 라운드마다 자기 턴이 돌아올때바다 성을 확장
 * 1 -> 2 -> 3 확장
 * 자신이 가지고 있는 성을 비어있는 칸으로 확장
 * Si칸만큼 이동할 수 있는 모든 칸에 성을 동시에 만든다
 * 벽이나 다른 플레이어의 성이 있는 곳으로는 이동할 수 없음
 * 성을 다 건설한 이후에는 다음 플레이어가 턴을 갖는다
 * 
 * 모든 플레이어가 더 이상 확장을 할 수 없을 때 게임이 끝남
 * 게임판의 초기 상태가 주어졌을 때 최종 상태 구하기
 * @author KOREA
 *
 */
public class Main {
	static int N,M,P;
	static int[] S;
	static int[][] arr; //0은 빈칸 -1은 벽
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static Queue<int[]> queue[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		S = new int[P+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=P;i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		arr = new int[N][M];
		
		queue = new LinkedList[P+1];
		for (int i=0;i<=P;i++) {
			queue[i] = new LinkedList<>();
		}
		
		for (int i=0;i<N;i++) {
			String input = br.readLine();
			for (int j=0;j<M;j++) {
				char ch = input.charAt(j);
				if (ch == '.') arr[i][j] = 0;
				else if (ch == '#') arr[i][j] = -1;
				else {
					arr[i][j] = ch-'0';
					queue[arr[i][j]].add(new int[] {i,j});
				}
			}
		}
		//------------------------------------------
		
		
		
		
		while (true) {
			int total = 0;
			for (int i=1;i<=P;i++) {
				total += bfs(i);
			}
			if (total == 0) break;
		}
		
		//각자 가진 성 수 구하기
		int[] answer = new int[P+1];
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				if (arr[i][j] > 0) answer[arr[i][j]]++;
			}
		}
		
		for (int i=1;i<=P;i++) {
			System.out.print(answer[i]+" ");
		}
	}
	
	//확장을 진행한 칸수 return
	public static int bfs(int player) {
		int depth = 0;
		int cnt = 0;
		
		while (!queue[player].isEmpty()) {
			if (depth >= S[player]) break;
			int qSize = queue[player].size();
			for (int q=0;q<qSize;q++) {
				int cur[] = queue[player].poll();
				int cur_x = cur[0];
				int cur_y = cur[1];
				
				for (int i=0;i<4;i++) {
					int nx = cur_x + dx[i];
					int ny = cur_y + dy[i];
					
					if (nx<0 || nx>=N || ny<0 || ny>=M) continue;
					
					if (arr[nx][ny] == 0) {
						arr[nx][ny] = player;
						cnt++;
						queue[player].add(new int[] {nx,ny});
					}
				}
			}
			depth++;
			
			
		}
		return cnt;
		
	}
	
	public static void printArr(int[][] arr) {
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}