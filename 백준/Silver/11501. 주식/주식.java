import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 주식 하나를 산다
 * 2. 원하는 만큼 가지고 있는 주식을 판다.
 * 3. 아무것도 안한다.
 * 
 * 날 별로 주식의 가격 --> 최대 이익이 얼마나 되는지 계산
 * 
 * @author SSAFY
 *
 */
public class Main {
	static int T;
	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0;t<T;t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long answer = 0;
			int max_value = 0;
			for (int i=N-1;i>=0;i--) {
				if (max_value <= arr[i]) {
					max_value = arr[i];
				} else {
					answer += (max_value - arr[i]);
				}
			}
			System.out.println(answer);
		}

	}

}