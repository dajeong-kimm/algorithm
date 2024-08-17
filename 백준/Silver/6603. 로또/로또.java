import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1 ~ 49 중 6개의 수
 * 
 * k개의 수를 골라 집합 S --> 그 수만 가지고 번호 선택
 * 
 * S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램
 * @author KOREA
 *
 */
public class Main {
	static int k;
	static int[] arr;
	static int[] answer;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		
		while (true) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0) {
				return;
			}
			arr = new int[k];
			for (int i=0;i<k;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			answer = new int[6];
			
			lotto(0,0);
			
			System.out.println(sb.toString());
//			System.out.println();
			
		}

	}
	private static void lotto(int cnt, int start) {
		if (cnt == 6) {
			for (int i=0;i<6;i++) {
				sb.append(answer[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=start;i<k;i++) {
			answer[cnt] = arr[i];
			lotto(cnt+1, i+1);
		}
		
			
	}

}