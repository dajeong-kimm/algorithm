import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 정수로 이루어진 수열
 * 크기가 양수인 부분수열 중에서
 * 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수
 * @author KOREA
 *
 */
public class Main {
	static int N,S;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		for (int mask=1;mask<(1<<N);mask++) {
			int tmp_sum = 0;
			for (int j=0;j<N;j++) {
				if ((mask&(1<<j)) != 0) {
					tmp_sum += arr[j];
				}
			}
			if (tmp_sum == S) answer++;
		}
		System.out.println(answer);

	}

}