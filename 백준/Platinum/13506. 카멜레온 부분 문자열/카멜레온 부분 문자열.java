import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		int[] table = makeTable(S);
//		System.out.println(Arrays.toString(table));
		
		int n = S.length();
		
		Set<Integer> lenSet = new HashSet<>();
		int len = table[n-1];
		
		while (len > 0) {
			lenSet.add(len);
			len = table[len-1];
		}
		
		String answer = "-1";
		
		ArrayList<Integer> list = new ArrayList<>(lenSet);
		Collections.sort(list, Collections.reverseOrder());
		
		for (int num : list) {
			if (kmp(S, S.substring(0,num), num)) {
				answer = S.substring(0, num);
				break;
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean kmp (String text, String pattern, int num) {
		int[] table = makeTable(pattern);
		
		int i=0;
		int j=0;
		
		while (i < text.length()) {
			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
				
				if (j == pattern.length()) {
					if (i == (num) || i == (text.length())) {
						j = table[j-1];
					}
					else return true;
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
		return false;
	}
	
	static int[] makeTable(String S) {
		int n = S.length();
		int[] table = new int[n];
		
		int len = 0;
		int i = 1;
		
		while (i < n) {
			if (S.charAt(len) == S.charAt(i)) {
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