import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 두 수가 서로소의 관계
 * n가 서로소 관계에 있는 k의 개수 : 오일러 피 이용
 * @author KOREA
 *
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		
		long pi = n;
		
		for (int i=2;i<=Math.sqrt(n);i++) {
			if (n%i==0) pi = pi / i * (i-1);
			while (n%i ==0) {
				n /= i;
			}
		
		}
		
		if (n != 1) pi = pi / n * (n-1);
		System.out.println(pi);

	}

}