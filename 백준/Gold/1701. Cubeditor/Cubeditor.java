import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String text = br.readLine();
		
		int answer = findLong(text);
		System.out.println(answer);

	}
	static int findLong(String text) {
		int n = text.length();
		int maxLen = 0;
		
		//모든 접미사에 대해 lps 배열 계산
		for (int i=0;i<n;i++) {
			String suffix = text.substring(i);
			int[] table = makeTable(suffix);
			
			for (int len : table) {
				maxLen = Math.max(maxLen,  len);
			}
		}
		return maxLen;
	}
	
	static int[] makeTable(String P) {
		int n = P.length();
		int[] table = new int[n];
		
		int len = 0;
		int i = 1;
		
		while (i < n) {
			if (P.charAt(len) == P.charAt(i)) {
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