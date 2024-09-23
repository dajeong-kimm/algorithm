import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 전화번호 목록
 * 
 * 전화번호 목록이 일관성을 유지하려면, 
 * 한 번호가 다른 번호의 접두어인 경우가 없어야 한다.
 * 
 * @author KOREA
 *
 */
public class Main {
	static int t;
	static int n;
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		for (int T=0;T<t;T++) {
			n = Integer.parseInt(br.readLine());
			
			String[] num = new String[n];
			for (int i=0;i<n;i++) {
				num[i] = br.readLine();
			}
			
			Arrays.sort(num);
			
			boolean answer = true;
			for (int i=0;i<num.length-1;i++) {
				if (num[i+1].startsWith(num[i])) {
					answer = false;
					break;
				}
			}
			
			if (answer) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}