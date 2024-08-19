import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정수 A를 B로
 * 
 * 1. 2를 곱한다
 * 2. 1을 수의 가장 오른쪽에 추가한다.
 * 
 * 필요한 연산의 최솟값
 * @author KOREA
 *
 */
public class Main {
	static int answer;
	
	static int A,B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		answer = 1;
		boolean flag = false;
		while (B != A) {
			int tmp = B;
			if (B%2 == 0) {
				B/=2;
			}
			else if (B%10 == 1){
				B/=10;
			}
			answer++;
			if (B == tmp) {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(answer);
		
	}

}