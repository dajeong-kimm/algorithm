import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] solve = new int[M]; //i 학생이 풀수 있는 문제들
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int canSolve = 0;
			for (int j=0;j<cnt;j++) {
				canSolve |= (1<<Integer.parseInt(st.nextToken())-1);
			}
			solve[i] = canSolve;
		}
		
//		System.out.println(Arrays.toString(solve));
		
		int answer = Integer.MAX_VALUE;
		for (int i=1;i<(1<<M);i++) {
			int curSolve = 0;
			int curCnt = 0;
			for (int j=0;j<M;j++) {
				if ((i & 1<<j) != 0) {
					curSolve |= solve[j];
					curCnt++;
				}
				if (curSolve == ((1<<N)-1)) {
					answer = Math.min(answer, curCnt);
				}
			}
		}
		
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}

}
