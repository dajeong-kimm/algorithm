import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[][] pos;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		pos = new int[N+1][2];
		for (int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			pos[i][0] = x;
			pos[i][1] = y;
		}
		
		int[][] dp = new int[N+1][K+1];
		
		for (int i = 0; i <= N; i++) {
	           for (int j = 0; j <= K; j++) {
	               dp[i][j] = Integer.MAX_VALUE/2;
	           }
	       }
		
		dp[1][0] = 0; // 시작점에서의 거리
		for (int i=2;i<=N;i++) {
			
			for (int j=0;j<=K;j++) {
				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + dist(i - 1, i));
				
				// j개의 체크포인트를 건너뛴 경우
                for (int skip = 1; skip <= j; skip++) {
                    if (i - skip - 1 >= 1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - skip - 1][j - skip] + dist(i - skip - 1, i));
                    }
                }
			}
		}
		
		
		int answer = Integer.MAX_VALUE;
        for (int j = 0; j <= K; j++) {
            answer = Math.min(answer, dp[N][j]);
        }

        System.out.println(answer);

	}
	
	static int dist(int from, int to) {
		int answer = 0;
		answer = Math.abs(pos[from][0] - pos[to][0]);
		answer += Math.abs(pos[from][1] - pos[to][1]);
		
		return answer;
	}

}