import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 어른 상어
 * 상어 : 1~M 자연수가 붙어있고, 모든 번호는 서로 다름
 * 1의 번호를 가진 어른 상어는 가장 강력해서 나머지 모두를 쫓아낼 수 있음
 * 
 * M개의 칸에 상어가 한 마리씩 들어 있음
 * 맨 처음에는 모든 상어가 자신의 위치에 자신의 냄새를 뿌림
 * 그 후 1초마다 모든 상어가 동시에 상하좌우 중 하나로 이동 --> 냄새를 그 칸에 뿌림
 * 냄새는 상어가 k번 이동하고 나면 사라짐
 * 
 * 이동방향을 결정할 때는 아무 냄새가 없는 칸의 방향으로 ,,
 * 그런 칸이 없으면 자신의 냄새가 있는 칸의 방향으로 
 * 이때 가능한 칸이 여러개라면 --> 특정한 우선순위 
 * 
 * 모든 상어가 이동한 후 한 칸에 여러 마리의 상어가 남아 있으면, 가장 작은 번호를 가진 상어를 제외하고 모두 격자 밖으로 
 * 
 * 1번 상어만 격자에 남게 되기까지 몇 초가 걸리는지 구하기
 * (1000초가 넘어도 다른 상어가 격자에 남아있으면 -1 출력하기)
 * @author KOREA
 *
 */
public class Main {
	static int N,M,K;
	static int[][] restTime; //각 칸마다 냄새가 없어지기까지 남은 시간
	static int[][] smell; //각 칸에 냄새를 뿌린 상어의 번호
	static int[][][] priority; //상어 번호, 현재 방향, 우선순위 방향
	static Shark[] shark; //1번부터 M번까지 각 상어의 위치와 방향 정보
	
	static int answer;
	
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,-1,1};
	
	static class Shark {
		int x,y,d;
		
		Shark(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //격자 크기
		M = Integer.parseInt(st.nextToken()); //상어 번호 
		K = Integer.parseInt(st.nextToken()); //냄새가 사라지기 까지 걸리는 시간
		
		restTime = new int[N][N];
		smell = new int[N][N];
		
		priority = new int[M+1][5][4];
		shark = new Shark[M+1];
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if (num > 0 ) {
					shark[num] = new Shark(i,j,0);
					restTime[i][j] = K; //냄새 남는 시간 설정
					smell[i][j] = num;
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=M;i++) {
			shark[i].d = Integer.parseInt(st.nextToken());
		}
		
		for (int i=1;i<=M;i++) {
			for (int j=1;j<=4;j++) {
				st = new StringTokenizer(br.readLine());
				for (int k=0;k<4;k++) {
					priority[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		//------------------------------------------------------------
		solve();
		System.out.println(answer);
		
	}
	public static void solve() {
		int time = 0;
		
		while (true) {
			int count = 0; //남은 상어의 수 
			for (int m=1;m<=M;m++) {
				if (shark[m] != null) count++;
			}
			
			//1번 상어만 남은 경우
			if (count == 1 && shark[1] != null) {
				answer = time;
				return;
			}
			
			//시간이 1000초 넘으면
			if (time >= 1000) {
				answer = -1;
				return;
			}
			
			//상어가 이동할 임시 위치를 저장
			int[][] tmp = new int[N][N];
			
			for (int m=1;m<=M;m++) {
				if (shark[m] != null) move(tmp,m);
			}
			
			//냄새 -1
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					if (restTime[i][j] > 0) restTime[i][j]--;
					if (restTime[i][j] == 0) smell[i][j] = 0;
				}
			}
			
			//이동 후 상어 위치에 냄새와 유효시간 저장
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					if (tmp[i][j] > 0) {
						restTime[i][j] = K;
						smell[i][j] = tmp[i][j]; 
					}
				}
			}
			
			//시간 증가
			time++;
		}
	}
	
	public static void move(int[][] tmp, int m) {
		int nx = 0;
		int ny = 0;
		int d = 0;
		boolean flag = false;
		
		//1. 냄새가 없는 곳을 우선순위에 따라 탐색
		for (int i=0;i<4;i++) {
			d = priority[m][shark[m].d][i];
			nx = shark[m].x + dx[d];
			ny = shark[m].y + dy[d];
			
			if (nx>=0 && nx<N && ny>=0 && ny<N && smell[nx][ny] == 0) {
				flag = true;
				break;
			}
		}
		
		//2. 냄새가 없는 곳이 없는 경우 자기 냄새가 있는 곳으로 이동
		if (!flag) {
			for (int i=0;i<4;i++) {
				d = priority[m][shark[m].d][i];
				nx = shark[m].x + dx[d];
				ny = shark[m].y + dy[d];
				
				if (nx>=0 && nx<N && ny>=0 && ny<N && smell[nx][ny] == m) {
					break;
				}
			}
		}
		
		//상어가 겹치지 않는 경우
		if (tmp[nx][ny] == 0) {
			tmp[nx][ny] = m;
			shark[m].x = nx;
			shark[m].y = ny;
			shark[m].d = d;
		}
		//상어가 겹치는 경우
		else {
			shark[m] = null;
		}
		
		
	}

}