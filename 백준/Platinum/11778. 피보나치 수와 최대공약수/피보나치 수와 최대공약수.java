import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * n번째 피보나치 수와 m번째 피보나치 수의 최대공약수
 * @author KOREA
 *
 */
public class Main {
	static int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		long gcdNum = gcd(N, M);
		
		long result = fibonacci(gcdNum);
		System.out.println(result);
		
	}
	static long[][] multiply(long[][] a, long[][] b){
		long[][] c = new long[2][2];
		c[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) %MOD;
		c[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        c[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        c[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;
        
        return c;
	}
	
	static long fibonacci(long gcd) {
		if (gcd == 0) return 0;
		
		long[][] result = {{1,0}, {0,1}};
		long[][] base = {{1,1}, {1,0}};
		
		gcd -= 1;
		while (gcd>0) {
			if (gcd%2 == 1) {
				result = multiply(result, base);
			}
			base = multiply(base, base);
			gcd /= 2;
		}
		
		return result[0][0];
	}
	
	static long gcd(long a, long b) {
		while (b != 0) {
			long tmp = b;
			b = a%b;
			a = tmp;
		}
		return a;
	}

}
