import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int maxP, maxQ;
	static long answer;
	static long D,P,Q;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		D = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		
		//항상 P>=Q가 되도록 정렬
		if (P < Q) {
			long tmp = P;
			P = Q;
			Q = tmp;
		}
		
		if (Q >= D) {
            System.out.println(Q);
            return;
        }
		
		answer = Long.MAX_VALUE;
		long lcm = lcm(P, Q);
		
		for (long i=0; i<= Math.min(D, lcm) + P; i+= P) {
			long target = Math.max(D-i, 0);
			long tmp = (target / Q) * Q;
			
			if (tmp < target) {
				tmp += Q;
			}
			
			answer = Math.min(answer,  tmp+i);
		}
		
		System.out.println(answer);
	}
	
	static long gcd(long a, long b) {
		while (b != 0) {
			long tmp = b;
			b = a%b;
			a = tmp;
		}
		return a;
	}
	
	static long lcm(long a, long b) {
		return a / gcd(a, b) * b;
	}
	
}