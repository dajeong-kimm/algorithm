import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 마법사 상어와 파이어볼
 * 
 * 크기가 N*N인 격자에 파이어볼 M개 발사
 *  위치, 질량, 방향, 속력
 *  (r,c) r행 c열
 *  1번행은 N번과 연결, 1번은 N번과 연결
 *  
 *  1. 모든 파이어볼은 자신의 방향으로 속력만큼 이동 (같은 칸에 여러개 있을 수도)
 *  2. 이동이 끝난 뒤 2개 이상의 파이어볼 :
 *  	-> 같은 칸에 있는 파이어볼은 하나로 합쳐짐
 *  	-> 파이어볼은 4개의 파이어볼로 나눠짐
 *  	-> 질량 : (질량의합) / 5
 *  	-> 속력 : (속력의합) / 합쳐진 갯수
 *  	-> 방향이 모두 홀수이거나 모두 짝수 : 0246 or 1357
 *  	-> 질량이 0인 파이어볼은 소멸
 *  마법사 상어가 이동을 K번 명령한 후 남아있는 파이어볼 질량의 합
 * @author KOREA
 *
 */
public class Main {
	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	
	static int N,M,K;
	
	static Queue<Ball> queue = new LinkedList<>();
	
	static Ball[][] arr;
	static Cell[][] map;
	static int[][] arr_M;
	static int[][] arr_S;
	static int[][] arr_Odd;
	
	static class Ball{
		int r,c;
		int m,s,d;

		Ball(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		
	}
	
	//질량합, 속력합, 방향상태, 방향, 갯수
	static class Cell {
		int sumM;
		int sumS;
		int dirState; //-1은 없음 0은 전체 짝수 1은 전체 홀수 2는 섞임
		int dir;
		int sumN;
		
		Cell(int sumM, int sumS, int dirState, int dir, int sumN){
			this.sumM = sumM;
			this.sumS = sumS;
			this.dirState = dirState;
			this.dir = dir;
			this.sumN = sumN;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			queue.add(new Ball(r,c,m,s,d));
			
		}
		
		map = new Cell[N+1][N+1];
		for (int k=0;k<K;k++) {
			//map 초기화
			//질량합, 속력합, 방향상태, 방향, 갯수
			for (int i=1;i<=N;i++) {
				for (int j=1;j<=N;j++) {
					map[i][j] = new Cell(0,0,-1,0,0);
				}
			}
			
			//모든 파이어봃 이동
			move();

			//2개 이상의 파이어볼이 있는 칸 -> 분열
			divide();
			
		}
		
		
		//남아있는 파이어볼의 질량
		int answer = 0;
		while (!queue.isEmpty()) {
			Ball b = queue.poll();
			answer += b.m;
		}
		System.out.println(answer);
	}
	public static void divide() {
		
		for (int i=1;i<=N;i++) {
			for (int j=1;j<=N;j++) {
				if (map[i][j].sumN == 1) {
					queue.add(new Ball(i,j,map[i][j].sumM, map[i][j].sumS, map[i][j].dir));
				}
				else {
					int m = map[i][j].sumM/5;
					if (m == 0) continue;
					
					int s = map[i][j].sumS / map[i][j].sumN;
					if (map[i][j].dirState == 2) {
						queue.add(new Ball(i,j,m,s,1));
						queue.add(new Ball(i,j,m,s,3));
						queue.add(new Ball(i,j,m,s,5));
						queue.add(new Ball(i,j,m,s,7));
					} else {
						queue.add(new Ball(i,j,m,s,0));
						queue.add(new Ball(i,j,m,s,2));
						queue.add(new Ball(i,j,m,s,4));
						queue.add(new Ball(i,j,m,s,6));
					}
				}
			}
		}
		
		
	}
	
	public static void move() {
		int queueSize = queue.size();
		
		for (int q=0;q<queueSize;q++) {
			Ball b = queue.poll();

			
			int nr = (b.r + dr[b.d] * b.s + N * 1001) % N;  // 행 이동
            int nc = (b.c + dc[b.d] * b.s + N * 1001) % N;  // 열 이동

            if (nr == 0) nr = N;
            if (nc == 0) nc = N;
//            
//            System.out.println("Moving ball from (" + b.r + "," + b.c + ") to (" + nr + "," + nc + ")");
			
            map[nr][nc].sumM += b.m;
            map[nr][nc].sumN++;
            map[nr][nc].sumS += b.s;
            map[nr][nc].dir = b.d;
            
            if (b.d%2 == 0) {
            	if (map[nr][nc].dirState == -1) map[nr][nc].dirState = 0;
            	else if (map[nr][nc].dirState == 1) map[nr][nc].dirState = 2;
            }
            else {
            	if (map[nr][nc].dirState == -1) map[nr][nc].dirState = 1;
            	else if (map[nr][nc].dirState == 0) map[nr][nc].dirState = 2;
            }
            
//			queue.add(new Ball(nr,nc,b.m,b.s,b.d));
			
			
		}
	}
	
	public static void printArr(int[][] cnt) {
		for (int i=0;i<cnt.length;i++) {
			for (int j=0;j<cnt[0].length;j++) {
				System.out.print(cnt[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}