import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); //팀의 개수
			int k = Integer.parseInt(st.nextToken()); //문제의 개수
			int teamNum = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken()); //로그 엔트리의 개수
			
			int rank = 1;
			
			int[][] scores = new int[k+1][n+1];
			int[] submitCnt = new int[n+1];
			int[] lastSubmit = new int[n+1];
			
			for (int i=1;i<=m;i++) {
				st = new StringTokenizer(br.readLine());
				int teamId = Integer.parseInt(st.nextToken());
				int problemNum = Integer.parseInt(st.nextToken());
				int score = Integer.parseInt(st.nextToken());
				scores[problemNum][teamId] = Math.max(scores[problemNum][teamId], score);
				submitCnt[teamId]++;
				lastSubmit[teamId] = i;
			}
			
			int[] totalScore = new int[n+1];
			for (int i=1;i<=n;i++) {
				for (int j=1;j<=k;j++) {
					totalScore[i] += scores[j][i];
				}
			}
			
			int myScore = totalScore[teamNum];
			for (int i=1;i<=n;i++) {
				if (i == teamNum) continue;
				
				if (myScore < totalScore[i]) rank++;
				else if (myScore == totalScore[i]) {
					//풀이 횟수가 내가 더 많으면 짐
					if (submitCnt[teamNum] > submitCnt[i]) rank++;
					
					//풀이 횟수가 같고 마지막 제출 시간이 더 늦으면 짐
					else if (submitCnt[teamNum] == submitCnt[i]) {
						if (lastSubmit[teamNum] > lastSubmit[i]) rank++;
					}
				}
			}
			sb.append(rank).append("\n");
		}
		System.out.println(sb);
		

	}

}
