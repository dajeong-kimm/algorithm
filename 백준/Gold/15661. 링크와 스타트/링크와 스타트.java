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
		
		//1부터 2^N-1까지 모든 경우의 수를 확인
		int fullTeam = (1<<N) - 1;
		for (int mask = 1;mask<(1<<N)-1;mask++) {
			int start = 0;
			int link = 0;
			for (int i=0;i<N;i++) {
				for (int j=i+1;j<N;j++) {
					if ((mask&(1<<i))!=0 && (mask&(1<<j))!=0) {
						start += arr[i][j];
						start += arr[j][i];
					}
					else if ((mask&(1<<i)) == 0 && (mask&(1<<j))==0) {
						link += arr[i][j];
						link += arr[j][i];
					}
				}
			}
			answer = Math.min(answer, Math.abs(start-link));
		}

		System.out.println(answer);
	}
	

}