import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 한번에 오른쪽 인접한 칸 또는 아래에 인접한 칸으로 이동
 * 2. 격자에 O로 표시된 칸이 있는 경우엔 로봇은 그 칸을 반드시 지나가야 함
 * 
 * 설명한 두 조건을 만족하면서 이동할 수 있는 서로 다른 경로가 총 몇개인지?
 * @author KOREA
 *
 */
public class Main {
	static int N,M,K;
	
	static int answer;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		answer = 0;
		if (K==0) {
			move(1,true);
		} else {
			move(1,false);
		}
		System.out.println(answer);

	}
	private static void move(int cur,boolean flag) {
//		System.out.println(cur);
		if (cur == K) flag = true;
		
		if (cur == N*M) {
			if (flag) answer++;
			return;
		}
		
		if (cur > N*M) return;
		
		
		if (cur%M == 0) {
			move(cur+M,flag);
		} else {
			move(cur+1,flag);
			move(cur+M,flag);
		}
	}

}