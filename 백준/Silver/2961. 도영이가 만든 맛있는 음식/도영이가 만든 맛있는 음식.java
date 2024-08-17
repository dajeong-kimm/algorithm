import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 메모리 : 
 * 시간 : 
 * 
 * 비트마스킹 이용
 * 각 비트가 특정 재료를 사용할지 여부를 나타냄
 * --> 모든 가능한 조합 탐색
 * @author KOREA
 *
 */
public class Main {

	static int N;
	static int[][] arr;
	static long answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		answer = Long.MAX_VALUE;
		
		for (int i=1;i<(1<<N);i++) {
			long s = 1;
			long b = 0;
			
			for (int j=0;j<N;j++) {
				//j번째 재료가 사용된 경우
				if ((i&(1<<j)) != 0) {
					s *= arr[j][0];
					b += arr[j][1];
				}
			}
			
			long diff = Math.abs(s-b);
			answer = Math.min(answer, diff);
		}
		
		System.out.println(answer);

}
}