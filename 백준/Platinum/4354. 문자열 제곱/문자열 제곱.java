import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String input = br.readLine();
			if (input.equals(".")) break;
			
			int[] table = makeTable(input);
//			System.out.println(Arrays.toString(table));
			
			int n = input.length();
			int len = table[n-1]; //접미사와 접두사가 일치하는 길이
			
			int patternLen = n - len;
			
			if (n % patternLen == 0) {
				sb.append(n / patternLen).append("\n");
			}
			else {
				sb.append(1).append("\n");
			}
		}
		
		System.out.println(sb);

	}
	
	static int[] makeTable(String P) {
		int n = P.length();
		int[] table = new int[n];
		int len = 0;
		int i = 1;
		
		while (i < n) {
			if (P.charAt(i) == P.charAt(len)) {
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