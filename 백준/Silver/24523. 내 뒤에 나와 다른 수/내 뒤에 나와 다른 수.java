import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 내 뒤에 나와 다른 수
 * @author KOREA
 *
 */
public class Main {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] answer = new int[N];
		answer[N-1] = -1;
		
		for (int i=N-2;i>=0;i--) {
			if (arr[i] != arr[i+1]) {
				answer[i] = i+2; 
			}
			else {
				answer[i] = answer[i+1];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<N;i++) {
			sb.append(answer[i]+" ");
		}
		System.out.println(sb);

	}

}