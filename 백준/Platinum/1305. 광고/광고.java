

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		
		int[] table = makeTable(input);
//		System.out.println(Arrays.toString(table));
		
		int answer = N - table[N-1];
		System.out.println(answer);
		
	}
	
	static int[] makeTable(String P) {
		int n = P.length();
		int[] table = new int[n];
		int len = 0;
		int i = 1;
		
		while (i<n) {
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
