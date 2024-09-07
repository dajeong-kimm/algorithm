import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 낚시왕
 * 
 * 상어는 크기와 속도
 * 낚시왕이 가장 오른쪽 열의 오른쪽 칸에 이동하면 이동을 멈춤
 * 1. 오른쪽 한 칸 이동
 * 2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 사라짐
 * 3. 상어가 이동
 * 
 * 상어는 주어진 속도로 이동
 * 이동하려는 칸이 격자판의 경계를 넘는 경우에는 반대로 속력을 유지한채 이동
 * 
 * 상어가 이동을 마친 후에 한 칸에 상어가 두마리 이상 있을 수 있다.
 * 크기가 가장 큰 상어가 나머지 상어를 잡아먹는다.
 * 
 * 상어 낚시를 하는 격자판의 상태가 주어졌을 때, 낚시왕이 잡은 상어 크기의 합 구하기
 * @author KOREA
 *
 */
public class Main {
	static int R,C,M;
	static Shark[][] arr;
	
	static int fishKing = 0;
	static int answer = 0;
	
	static int dr[] = {0,-1,1,0,0};
	static int dc[] = {0,0,0,1,-1};
	
	public static class Shark implements Comparable<Shark>{
		int x,y;
		int v;
		int d;
		int size;
		Shark(int x, int y, int v, int d, int size) {
			this.x = x;
			this.y = y;
			this.v = v;
			this.d = d;
			this.size = size;
		}
		
		@Override
		public int compareTo(Shark o) {
			return Integer.compare(o.size, size); //상어의 사이즈가 큰 순으로 내림차순
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); //상어의 수 
		
		arr = new Shark[R+1][C+1];
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken()); //속력
			int d = Integer.parseInt(st.nextToken()); //이동방향
			int z = Integer.parseInt(st.nextToken()); //크기
			
			arr[r][c] = new Shark(r,c,s,d,z);
		}
//		System.out.println("initial: ");
//		printShark(arr);
//		System.out.println("-----------------------");
		
		while (true) {
			if (fishKing == C) break;
			fishKing++; //오른쪽으로 한 칸 이동
			
			fishing();
//			System.out.println("after fishing");
//			printShark(arr);
			
			moving();
//			System.out.println("after moving");
//			printShark(arr);
			
//			System.out.println("-----------------------");

		}
		
		System.out.println(answer);
		
	}
	public static void fishing() {
		for (int i=1;i<=R;i++) {
			if (arr[i][fishKing] != null) {
				answer += arr[i][fishKing].size;
				arr[i][fishKing] = null;
				return;
			}
		}
	}
	public static void moving() {
		PriorityQueue<Shark> pq = new PriorityQueue<>();
		//하나씩 null로 바꾸면서 이동시키기
		for (int i=1;i<=R;i++) {
			for (int j=1;j<=C;j++) {
				if (arr[i][j] != null) {
					Shark s = arr[i][j]; //r , c, d 리턴
					//속력 최적화
					int velocity = s.v;
					if (s.d <=2) {
						velocity %= ((R-1)*2);
					} else {
						velocity %= ((C-1)*2);
					}
					
					int info[] = move(s.x, s.y, velocity, s.d);
					
					arr[i][j] = null;
					pq.add(new Shark(info[0], info[1], s.v, info[2], s.size));
				}
			}
		}
		
		//같은 위치에 있는 상어중에 제일 큰것만 위치시키기 (우선순위 큐, size 큰 것부터 가져오기)
		while (!pq.isEmpty()) {
			Shark cur = pq.poll();
			
			if (arr[cur.x][cur.y] == null) {
				arr[cur.x][cur.y] = cur;
			}
		}
	}
	
	
	public static int[] move(int r, int c, int v, int d) {
		int[] result = new int[3]; //새로운 위치 , 방향 리턴
		int new_r = r;
		int new_c = c;
		int new_d = d;
		
		while (v>0) {
			int nr = new_r + dr[new_d];
			int nc = new_c + dc[new_d];
			
			if (nr<1 || nr > R || nc < 1 || nc > C) {
				if (new_d == 1) new_d = 2;
				else if (new_d == 2) new_d = 1;
				else if (new_d == 3) new_d = 4;
				else if (new_d == 4) new_d = 3;
				
				continue;
			}
			
			new_r = nr;
			new_c = nc;
			v--;
		}
		
		return new int[] {new_r, new_c, new_d};
	}
	
	//상어의 size만큼 출력 (디버깅)
	public static void printShark(Shark[][] arr) {
		for (int i=1;i<=R;i++) {
			for (int j=1;j<=C;j++) {
				if (arr[i][j] == null) {
					System.out.print(0);
				}
				else {
					System.out.print(arr[i][j].size);
				}
			}
			System.out.println();
		}
	}

}