import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//		System.out.println(gcd(4,2));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//최소공배수 구하기
		long num = arr[0];
		for (int i=1;i<N;i++) {
			long gcd = gcd(num, arr[i]);
			num = (num*arr[i])/gcd;
		}
		
		//분자
		long A = 0;
		for (int i=0;i<N;i++) {
			A += (num/arr[i]);
		}
		
		//분모와 분자의 최대공약수
		long X = gcd(A,num);
//		if ((A/X) == 1) {
//			System.out.println((num/X));
//			return;
//		}
		
		System.out.println((num/X)+"/"+(A/X));
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