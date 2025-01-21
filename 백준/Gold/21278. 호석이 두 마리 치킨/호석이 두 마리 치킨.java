import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int answer = Integer.MAX_VALUE/2;
	static int small, big;
	
	static List<Integer> graph[];
	static int N, M;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] cost = new int[N+1][N+1];
		for (int i=1;i<=N;i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE/3);
		}
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			cost[a][b] = 1;
			cost[b][a] = 1;
		}

		
		for (int i=1;i<=N;i++) {
			cost[i][i] = 0;
		}
		
		for (int k=1;k<=N;k++) {
			for (int i=1;i<=N;i++) {
				for (int j=1;j<=N;j++) {
					if (cost[i][k] == Integer.MAX_VALUE || cost[k][j] == Integer.MAX_VALUE) continue;
					
					if (cost[i][k] + cost[k][j] < cost[i][j]) {
						cost[i][j] = cost[i][k] + cost[k][j];
					}
				}
			}
		}
		
		//debug
//		for (int i=1;i<=N;i++) {
//			for (int j=1;j<=N;j++) {
//				System.out.print(cost[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		for (int i=1;i<N;i++) {
			for (int j=i+1;j<=N;j++) {
				int tmpDist = 0;
				
				for (int x=1;x<=N;x++) {
					int a = cost[x][i] + cost[i][x];
					int b = cost[x][j] + cost[j][x];
					tmpDist += Math.min(a, b);
				}
				
				if (answer > tmpDist) {
					answer = tmpDist;
					small = i;
					big = j;
				}
			}
		}
		
		System.out.println(small+" "+big+" "+answer);
	}
	

}