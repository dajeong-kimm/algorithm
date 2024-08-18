import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 자연수 A를 B번 곱한 수
 * 이를 C로 나눈 나머지를 구하는 프로그램
 * @author KOREA
 *
 */
public class Main {
	static long A,B,C;
	
	static long answer;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		answer = multiple(A,B);
		System.out.println(answer);

	}
	private static long multiple(long A, long B) {
		if (B==1) {
			return A%C;
		}
		
		long tmp = multiple(A,B/2);
		if (B%2==0) {
			return (tmp*tmp)%C;
		} else {
			return (((tmp*tmp)%C)*A)%C;
		}
	}

}