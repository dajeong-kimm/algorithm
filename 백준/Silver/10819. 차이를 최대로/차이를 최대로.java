import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정수의 순서를 적절히 바꿔서 ~
 * @author KOREA
 *
 */
public class Main {
	static int N;
	static int[] arr;
	
	static int[] tmp;
	static boolean[] selected;
	
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		tmp = new int[N];
		selected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = 0;
		permutation(0);
		System.out.println(answer);
		

	}
	public static void permutation(int cnt) {
		if (cnt == N) {
			int cur = test();
			if (cur > answer) {
				answer = cur;
			}
			return;
		}
		
		for (int i=0;i<N;i++) {
			if (!selected[i]) {
				tmp[cnt] = arr[i];
				selected[i] = true;
				permutation(cnt+1);
				selected[i] = false;
			}
		}
	}
	public static int test() {
		int result = 0;
		for (int i=1;i<N;i++) {
			result += Math.abs(tmp[i]-tmp[i-1]);
		}
		return result;
	}

}
