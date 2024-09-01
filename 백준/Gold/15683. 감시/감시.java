import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 메모리 : 
 * 실행 시간 : 
 * 
 * 5가지 CCTV
 * 1번 : 한쪽
 * 2번 : 서로 반대
 * 3번 : 직각
 * 4번 : 세방향
 * 5번 : 네방향
 * 
 * CCTV가 감시할 수 없는 영역은 사각지대
 * 
 * 0은 빈칸 6은 벽 1~5는 CCTV의 번호
 * 
 * 사무실의 크기와 상태, CCTV 정보가 주어졌을 때, CCTV의 방향을 적절히 정해서, 사각지대의 최소 크기를 구하는
 * @author SSAFY
 *
 */
public class Main {
	static int N,M;
	static int[][] arr;
//	static int[][] copy_arr;
	
	static ArrayList<int[]> cctv;
	static int cctv_cnt;
	
	static int answer;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cctv = new ArrayList<>();
		arr = new int[N][M];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j]>=1 && arr[i][j]<=5) {
					cctv.add(new int[] {i,j});
				} 
			}
		}
		//---------------------------------------------------------------------
		
		answer = Integer.MAX_VALUE;
		cctv_cnt = cctv.size();
		
		dfs(0);
		
		System.out.println(answer);
		

	}
	
	public static void dfs(int cur) {
		if (cur == cctv_cnt) {
			int tmp = countZone();
//			System.out.println(tmp);
//			print(arr);
//			System.out.println("--------------");
			answer = Math.min(answer, tmp);
			return;
		}
		
		int x = cctv.get(cur)[0];
		int y = cctv.get(cur)[1];
		
		int num = arr[x][y];
		
		int[][] copy_arr;
		
		 // CCTV 종류에 따른 방향 설정
        if (num == 1) {
            for (int i = 0; i < 4; i++) {
                copy_arr = copy(arr); // 현재 상태 복사
                change(x, y, i); // 해당 방향으로 변화
                dfs(cur + 1);
                arr = copy(copy_arr); // 복사본으로 복원
            }
        } else if (num == 2) {
            // 서로 반대 방향으로 두 번 체크
            for (int i = 0; i < 2; i++) {
                copy_arr = copy(arr);
                change(x, y, i);
                change(x, y, i + 2);
                dfs(cur + 1);
                arr = copy(copy_arr);
            }
        } else if (num == 3) {
            // 직각으로 두 번 체크
            for (int i = 0; i < 4; i++) {
                copy_arr = copy(arr);
                change(x, y, i);
                change(x, y, (i + 1) % 4);
                dfs(cur + 1);
                arr = copy(copy_arr);
            }
        } else if (num == 4) {
            // 세 방향으로 세 번 체크
            for (int i = 0; i < 4; i++) {
                copy_arr = copy(arr);
                change(x, y, i);
                change(x, y, (i + 1) % 4);
                change(x, y, (i + 2) % 4);
                dfs(cur + 1);
                arr = copy(copy_arr);
            }
        } else if (num == 5) {
            // 네 방향 모두 체크
            copy_arr = copy(arr);
            change(x, y, 0);
            change(x, y, 1);
            change(x, y, 2);
            change(x, y, 3);
            dfs(cur + 1);
            arr = copy(copy_arr);
        }
		
		
	}
	
	public static void change(int x, int y, int d) {
	    int now_x = x;
	    int now_y = y;

	    while (true) {
	        now_x += dx[d];
	        now_y += dy[d];
	        if (now_x < 0 || now_x >= N || now_y < 0 || now_y >= M || arr[now_x][now_y] == 6) break;

	        if (arr[now_x][now_y] == 0) arr[now_x][now_y] = 9;
	    }

	}

	
//	public static void change(int x, int y, int d) {
//		int now_x = x;
//		int now_y = y;
//		
//		while (now_x>0 && now_x<N-1 && now_y>0 && now_y<M-1) {
//			now_x += dx[d];
//			now_y += dy[d];
//			if (arr[now_x][now_y]==6) return;
//			else if (arr[now_x][now_y]==0) arr[now_x][now_y] = -1;
//		}
//	}
	
	public static int countZone() {
		int result = 0;
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				if (arr[i][j] == 0) result++;
			}
		}
		return result;
	}
	
	public static int[][] copy(int[][] arr) {
		int[][] result = new int[N][M];
		for (int i=0;i<N;i++) {
			System.arraycopy(arr[i], 0, result[i], 0, M);
		}
		return result;
	}
	
	public static void print(int[][] arr) {
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}