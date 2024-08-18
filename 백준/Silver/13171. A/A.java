import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 음이 아닌 두 정수 A, X
 * A^X를 구하는 방법
 * @author KOREA
 *
 */
public class Main {
	static long A,X;
	
	static long mod = 1_000_000_007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		A = Long.parseLong(br.readLine());
		X = Long.parseLong(br.readLine());
		
		System.out.println(square(A,X));
	}
	
	private static long square(long A, long X) {
		if (X==1) {
			return A%mod;
		}
		
		long tmp = square(A,X/2);
		if (X%2 == 0) {
			return (tmp*tmp)%mod;
		} else {
			return (((tmp*tmp)%mod)*(A%mod))%mod;
		}
	}

}