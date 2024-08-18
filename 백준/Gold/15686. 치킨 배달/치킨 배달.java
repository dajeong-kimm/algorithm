import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 빈칸 0
 * 치킨집 2
 * 집 1
 * 
 * 치킨거리 : 집과 가장 가까운 치킨집 사이의 거리
 * 
 * 도시의 치킨거리 : 모든 치킨 거리의 합
 * 
 * 치킨집	 중에서 M개를 고르고, 나머지는 폐업
 * 어떻게 고르면, 도시의 치킨 거리가 가장 작게 될지 구하는 프로그램
 * @author KOREA
 *
 */
public class Main {
	static int N,M;
	
	static int[][] arr;
	
	static int[][] new_arr;
	
	static int[] selected;
	
	static ArrayList<int[]> c_list;
	
	static int answer;
	
	static int c_count;
	
	static int[][] visited;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		selected = new int[M];
		c_list = new ArrayList<>();
		answer = Integer.MAX_VALUE;
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp==2) {
					c_list.add(new int[] {i,j});
				}
				arr[i][j] = tmp;
			}
		}
		
		c_count = c_list.size();
		
		Combi(0,0);
		System.out.println(answer);
		

	}
	
	private static void Combi(int start,int cnt) {
		if (cnt == M) {
			int count = 0;
			
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					if (arr[i][j] == 1) {
						int tmp = Integer.MAX_VALUE;
						for (int x=0;x<cnt;x++) {
							int[] cur = c_list.get(selected[x]);
							int cur_x = cur[0];
							int cur_y = cur[1];
							int t = Math.abs(i-cur_x)+Math.abs(j-cur_y);
							tmp = Math.min(tmp, t);
						}
						count += tmp;
					}
				}
			}
			answer = Math.min(answer, count);
			
			return;
		}
		for (int i=start;i<c_count;i++) {
			selected[cnt] = i;
			Combi(i+1,cnt+1);
		}
	}

}