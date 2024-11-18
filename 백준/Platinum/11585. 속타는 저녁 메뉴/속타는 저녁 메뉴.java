import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char[] pattern;
	static char[] text;
	
	static int cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		pattern = new char[N];
		text = new char[2*N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			pattern[i] = st.nextToken().charAt(0);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			text[i] = st.nextToken().charAt(0);
			text[i+N] = text[i];
		}
		kmp();
		
		int gcd = gcd(cnt, N);
		N /= gcd;
		cnt /= gcd;
		
		System.out.println(cnt+"/"+N);
		
	}
	static int gcd(int a, int b) {
		while (b != 0) {
			int tmp = b;
			b = a%b;
			a = tmp;
		}
		return a;
	}
	
	static void kmp() {
		int i = 0;
		int j = 0;
		
		int[] table = makeTable();
		
		while (i < 2*N-1) {
			if (text[i] == pattern[j]) {
				i++;
				j++;
				
				if (j == N) {
					j = table[j-1];
					cnt++;
				}
			}
			else {
				if (j > 0) {
					j = table[j-1];
				}
				else {
					i++;
				}
			}
		}
	}
	
	static int[] makeTable() {
		int[] table = new int[N];
		
		int len = 0;
		int i = 1;
		
		while (i < N) {
			if (pattern[len] == pattern[i]) {
				len++;
				table[i] = len;
				i++;
			}
			else {
				if (len > 0) {
					len = table[len-1];
				}
				else {
					table[i] = 0;
					i++;
				}
			}
		}
		return table;
	}

}