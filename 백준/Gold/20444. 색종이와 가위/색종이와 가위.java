import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		
		//x^2 -nx + (k-n-1) = 0
		
		//n^2 - 4k +4n + 4
		
		long test = n*n - 4*k + 4*n + 4;
		if (test < 0) {
			System.out.println("NO");
			return;
		}
		
		
		long sqrt = (long) Math.sqrt(test);
		if (sqrt * sqrt != test) {
			System.out.println("NO");
			return;
		}
		
		double x1 = (n + sqrt) / 2;
		double x2 = (n - sqrt) / 2;
//		System.out.println(x1+" "+x2);
		if ((x1 >= 0 && x1 <= n &&  (int) x1 == (int)x1) || (x2>=0 && x2 <= n && (int) x2 == (int)x2)) {
			System.out.println("YES");
			return;
		}
		System.out.println("NO");
		

	}
	
	

}