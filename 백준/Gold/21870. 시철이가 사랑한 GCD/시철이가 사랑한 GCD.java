import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long answer;
	static int N;
	static int S[];
	
	static int gcd(int a, int b) {
		if (b>a) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		while (b != 0) {
			int n = a % b;
			a = b;
			b = n;
		}
		return a;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		S = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(beauty(1, N, N));
	}
	
	static long beauty(int start, int end, int cnt) {
		if (cnt == 1) {
			return S[start];
		}
		
		long left = termGCD(start, start+cnt/2-1) + beauty(start+cnt/2, end, end-start-cnt/2+1);
		long right = termGCD(start+cnt/2, end) + beauty(start, start+cnt/2-1, cnt/2);
		
		return Math.max(left, right);		
	}
	
	static int termGCD(int left, int right) {
		int result = S[left];
		for (int i=left+1;i<=right;i++) {
			result = gcd(result, S[i]);
		}
		return result;
	}

}
