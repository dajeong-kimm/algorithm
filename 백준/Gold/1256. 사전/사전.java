import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사전
 * 모든 문자열은 N개의 a와 M개의 z로 이루어짐
 * 사전에는 알파벳 순서대로 수록
 * 
 * N,M,K --> K번째 문자열이 무엇인지?
 * 1<=N,M<=100
 * 1<=K<=1_000_000_000 (10억) 10^9
 * 규완이의 사전에 수록되어 있는 문자열의 개수가 K보다 작으면 -1 출력
 * 
 * n개의 문자와 m개의 문자를 조합하여 만들 수 있는 문자열의 개수
 * dp[n][m] : dp[n-1][m] + dp[n][m-1]
 * 
 * 
 * 
 * @author KOREA
 *
 */
public class Main {
	static double[][] dp;
	static StringBuilder res = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		double K = Double.parseDouble(st.nextToken());
		
		dp = new double[N+1][M+1];
		getResult(N,M,K);
		
		if (check(N,M) < K) {
			System.out.println(-1);
		} else {
			System.out.println(res.toString());
		}
		

	}
	public static double check(int N, int M) {
		if (N == 0 || M == 0) {
			return 1;
		}
		if (dp[N][M] != 0) {
			return dp[N][M];
		}
		return dp[N][M] = Double.min(check(N-1,M)+check(N,M-1), 1_000_000_001);
	}
	
	public static void getResult(int N, int M, double d) {
		if (N == 0) {
			for (int i=0;i<M;i++) {
				res.append("z");
			}
			return;
		}
		
		if (M == 0) {
			for (int i=0;i<N;i++) {
				res.append("a");
			}
			return;
		}
		
		double check = check(N-1,M);
		
		if (d > check) {
			res.append("z");
			getResult(N, M-1, d-check);
		}
		else {
			res.append("a");
			getResult(N-1, M, d);
		}
	}

}