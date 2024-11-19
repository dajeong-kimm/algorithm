import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] dist;
	
	static int INF = Integer.MAX_VALUE/2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		dist = new int[N+1][N+1];
		for (int i=0;i<=N;i++) {
			Arrays.fill(dist[i], INF);
		}
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a == -1 && b == -1) break;
			dist[a][b] = 1;
			dist[b][a] = 1;
		}
		
		for (int k=1;k<=N;k++) {
			for (int i=1;i<=N;i++) {
				for (int j=1;j<=N;j++) {
					if (i == j) continue;
					
					int dist1 = dist[i][k];
					int dist2 = dist[k][j];
					
					if (dist1 == INF || dist2 == INF) continue;
					
					if ((dist1+dist2) < dist[i][j]) {
						dist[i][j] = (dist1+dist2);
					}
				}
			}
		}
		
//		for (int i=1;i<=N;i++) {
//			for (int j=1;j<=N;j++) {
//				System.out.print(dist[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		int totalMin = INF;
		int[] score = new int[N+1];
		for (int i=1;i<=N;i++) {
			int tmpMax = 0;
			for (int j=1;j<=N;j++) {
				if (dist[i][j] != INF) {
					tmpMax = Math.max(tmpMax, dist[i][j]);
				}
			}
			score[i] = tmpMax;
			totalMin = Math.min(totalMin, score[i]);
		}
		
		int cnt = 0;
		List<Integer> answer = new ArrayList<>();
		for (int i=1;i<=N;i++) {
			if (score[i] == totalMin) {
				answer.add(i);
			}
		}
		
		System.out.println(totalMin+" "+answer.size());
		for (int i=0;i<answer.size();i++) {
			System.out.print(answer.get(i)+" ");
		}
		
	}

}
