import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for (int i=1;i<=Math.min(98765, N-1);i++) {
			visit = new boolean[10];
			int other = N - i;
			if (isAvail(i) && isAvail(other)) {
				System.out.println(i+" + "+other);
				return;
			}
		}
		
		System.out.println(-1);
		
	}
	
	static boolean isAvail(int num) {
		String n = String.valueOf(num);
		
		for (int i=0;i<n.length();i++) {
			char ch = n.charAt(i);
			if (visit[ch-'0']) return false;
			visit[ch-'0'] = true;
		}
		
		return true;
	}

}