import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int answer;
	static int N;
	static int[] row;
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		row = new int[N];
		answer = 0;
		backtracking(0);
		System.out.println(answer);
		
	}
	private static void backtracking(int x) {
		if (x==N) {
			answer++;
			return;
		}
		for (int i=0;i<N;i++) {
			row[x] = i;
			if (isPromising(x)) {
				backtracking(x+1);
			}
		}
	}
	
	private static boolean isPromising(int x) {
		for (int i=0;i<x;i++) {
			if (row[x] == row[i] || Math.abs(row[x]-row[i]) == Math.abs(x-i)) {
				return false;
			}
		}
		return true;
	}
}