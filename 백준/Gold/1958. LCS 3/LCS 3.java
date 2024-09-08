import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * LCS 3
 * 문자열 3개의 LCS 구하기
 * @author KOREA
 *
 */
public class Main {
	static String a,b,c;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		a = br.readLine();
		b = br.readLine();
		c = br.readLine();
		
		int len = LCS3();
		System.out.println(len);

	}
	public static int LCS3() {
		int[][][] dp = new int[a.length()+1][b.length()+1][c.length()+1];
		
		for (int i=1;i<=a.length();i++) {
			char ch1 = a.charAt(i-1);
			
			for (int j=1;j<=b.length();j++) {
				char ch2 = b.charAt(j-1);
				
				for (int k=1;k<=c.length();k++) {
					char ch3 = c.charAt(k-1);
					
					if (ch1 == ch2 && ch2 == ch3) {
						dp[i][j][k] = dp[i-1][j-1][k-1]+1;
					}
					else {
						dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
					}
				}
			}
		}
		return dp[a.length()][b.length()][c.length()];
	}

}