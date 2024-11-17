
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		int[] B = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int[] diff1 = compute(A, N);
		int[] diff2 = compute(B, N);
		
		int[] doubleDiff2 = new int[2*N];
		for (int i=0;i<N;i++) {
			doubleDiff2[i] = diff2[i];
			doubleDiff2[i+N] = diff2[i];
		}
		
		if (kmp(diff1, doubleDiff2)) {
			System.out.println("possible");
		}
		else {
			System.out.println("impossible");
		}
	}
	static boolean kmp (int[] p, int[] t) {
		int[] table = makeTable(p);
		
		int i = 0;
		int j = 0;
		
		while (i < t.length) {
			if (t[i] == p[j]) {
				i++;
				j++;
				
				if (j == p.length) return true;
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
		return false;
	}
	
	static int[] makeTable(int[] pattern) {
		int n = pattern.length;
		int[] table = new int[n];
		int len = 0;
		int i = 1;
		
		while (i<n) {
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
	
	static int[] compute(int[] arr, int n) {
		int[] diff = new int[n];
		for (int i=0;i<n-1;i++) {
			diff[i] = arr[i+1] - arr[i];
		}
		diff[n-1] = (arr[0]+360_000 - arr[n-1])%360_000;
		return diff;
	}

}
