import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 조각 움직이기
 * 최대 5개의 조각이 있는 5*5크기의 보드
 * 조각을 적절히 움직여서 모든 조각이 연결 요소를 이루게 하려고 함
 * 상하좌우로 인접한 조각을 모두 연결했을 때, 모든 쌍의 조각이 적어도 하나의 경로로 연결되어야 함
 * 
 * 한 번의 이동으로 하나의 조각을 상하좌우 인접한 칸으로 옮길 수 있음
 * 
 * 보드의 상태가 주어질 때, 최소 몇 번 이동해야 모든 조각이 연결 요소를 이루게 되는지 구하는 프로그램
 * @author KOREA
 *
 */
public class Main {
	static int[][] arr;
	static int initial;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[5][5];
		initial = 0; //비트마스크로 초기 배열의 상태 표현
		for (int i=0;i<5;i++) {
			String input = br.readLine();
			for (int j=0;j<5;j++) {
				if (input.charAt(j) == '*') {
					arr[i][j] = 1;
					initial |= (1<<(i*5 + j));
				}
			}
		}
		//---------------------------------------------
		int result = bfs(initial);
		System.out.println(result);
	}
	public static int countConnected(int state) {
		visited = new boolean[5][5];
		int cnt = 0;
		
		for (int i=0;i<5*5;i++) {
			if ((state & (1<<i)) != 0) {
				int x = i/5;
				int y = i%5;
				return dfs(x,y,state);
			}
		}
		return cnt;
	}
	public static int dfs(int x, int y, int state) {
		visited[x][y] = true;
		int count = 1;
		
		for (int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx<0 || nx>=5 || ny<0 || ny>=5) continue;
			if (visited[nx][ny]) continue;
			if ((state & (1<<(nx*5 + ny))) == 0) continue;
			
			count += dfs(nx,ny,state);
		}
		return count;
	}
	
	public static int bfs(int initial) {
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> moveCnt = new LinkedList<>();
		q.add(initial);
		moveCnt.add(0);
		Set<Integer> visitState = new HashSet<>();
		visitState.add(initial); //초기 상태를 방문 처리
		
		while (!q.isEmpty()) {
			int state = q.poll();
			int moves = moveCnt.poll();
			
			//연결된 조각이 현재 조각 수와 같으면 종료
			if (countConnected(state) == Integer.bitCount(state)) {
				return moves;
			}
			
			//상하좌우 이동 가능한 조각 상태를 큐에 추가
			for (int i=0;i<5*5;i++) {
				if ((state & (1<<i)) != 0) {
					int x = i/5;
					int y = i%5;
					
					for (int d=0;d<4;d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						
						if (nx<0 || nx>=5 || ny<0 || ny>=5) continue;
						//이미 조각이 있는 위치이면 continue
						if ((state & (1<<(nx*5+ny))) != 0) continue;
						
						int newState = state & ~(1<<i); //현재 위치를 0으로 만들기
						newState |= (1<<(nx*5+ny)); //새로운 위치를 1로 설정
						
						if (!visitState.contains(newState)) {
							q.add(newState);
							moveCnt.add(moves + 1);
							visitState.add(newState);
						}
					}
				}
			}
		}
		return -1; //모든 경우에 대해 이동을 실패한 경우
	}

}