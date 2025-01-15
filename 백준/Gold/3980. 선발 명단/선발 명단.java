import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int answer;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t=0;t<T;t++) {
			arr = new int[12][12];
			for (int i=1;i<=11;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=1;j<=11;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[12];
			answer = 0;
			combination(1, 0);
			sb.append(answer).append("\n");
			
		}
		System.out.println(sb);
		
		
	}
	
	static void combination(int cur, int point) {
		if (cur > 11) {
			answer = Math.max(answer, point);
			return;
		}
		
		for (int i=1;i<=11;i++) {
			if (arr[cur][i] != 0 && !visited[i]) {
				visited[i] = true;
				combination(cur+1, point+arr[cur][i]);
				visited[i] = false;
			}
		}
	}

}