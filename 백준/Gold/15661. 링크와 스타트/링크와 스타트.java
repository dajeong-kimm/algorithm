import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 축구를 하기 위해 총 N명이 모임
 * 스타트팀 vs 링크팀
 * 두 팀의 인원수는 같지 않아도됨, but 한 명 이상
 * 
 * Sij : i번 사람과 j번 사람이 같은 팀에 속했을 때 팀에 더해지는 능력
 * 
 * 스타트팀과 링크팀의 능력치 차이를 최소화
 * 
 * --> 스타트팀과 링크팀의 능력치 차이의 최솟값 출력
 * @author KOREA
 *
 */
public class Main {
	static int N;
	
	static int[][] arr;
	
	static int answer;

	static boolean[] visited;
	
	static int total_score;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];
		total_score = 0;
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
//				total_score += arr[i][j];
			}
		}
		
		
		answer = Integer.MAX_VALUE;
		
		subset(0);

		System.out.println(answer);
	}
	private static void subset(int cnt) {
		if (cnt == N) {
			int start = 0;
			int link = 0;
			for (int i=0;i<N-1;i++) {
				for (int j=i+1;j<N;j++) {
					if (visited[i] && visited[j]) {
						start += arr[i][j];
						start += arr[j][i];
					}
					if (!visited[i] && !visited[j]) {
						link += arr[i][j];
						link += arr[j][i];
					}
				}
			}
//			int link = total_score - start;
			answer = Math.min(answer, Math.abs(start-link));
			return;
		}
		
		visited[cnt] = true;
		subset(cnt+1);
		
		visited[cnt] = false;
		subset(cnt+1);
	}
	

}