import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	static String N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = br.readLine();
		int cnt = 0;
		for (int i=0;i<N.length();i++) {
			char ch = N.charAt(i);
			if (ch%2 == 1) cnt++;
		}
		
		makeNum(N, cnt);
		System.out.println(min+" "+max);
		
	}
	
	static void makeNum(String N, int oddCnt) {
//		System.out.println(N+" "+oddCnt);
		if (N.length() == 1) {
			min = Math.min(min, oddCnt);
			max = Math.max(max, oddCnt);
			return;
		}
		
		if (N.length() == 2) {
			int a = N.charAt(0)-'0';
			int b = N.charAt(1)-'0';
			
			String newN = String.valueOf(a+b);
			int cnt = 0;
			for (int i=0;i<newN.length();i++) {
				char ch = newN.charAt(i);
				int chNum = ch - '0';
				if (chNum % 2 == 1) cnt++;
			}
			
			makeNum(newN, oddCnt+cnt);
		}
		
		if (N.length() >= 3) {
			//1~N-1까지 중에 2개 고르기
			for (int i=1;i<=N.length()-2;i++) {
				for (int j=i+1;j<=N.length()-1;j++) {
					String newN = addNum(N, i, j);
					
					int cnt = 0;
					for (int pos=0;pos<newN.length();pos++) {
						char ch = newN.charAt(pos);
						int chNum = ch - '0';
						if (chNum%2 == 1) cnt++;
					}
					
					makeNum(newN, oddCnt+cnt);
				}
			}
		}
	}
	
	static String addNum(String N, int first, int second) {
		int a = Integer.parseInt(N.substring(0, first));
		int b = Integer.parseInt(N.substring(first, second));
		int c = Integer.parseInt(N.substring(second, N.length()));
		
		return String.valueOf(a+b+c);
	}

}
