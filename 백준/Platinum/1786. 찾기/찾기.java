
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String T = br.readLine();
		String P = br.readLine();
		
		List<Integer> result = kmp(T,P);
		
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");
		for (int pos : result) {
			sb.append((pos+1)).append(" ");
		}
		System.out.println(sb);

	}
	static List<Integer> kmp(String T, String P){
		int[] lps = lps(P);
		List<Integer> positions = new ArrayList<>();
		
		int i = 0;
		int j = 0;
		
		while (i < T.length()) {
			if (T.charAt(i) == P.charAt(j)) {
				i++;
				j++;
				
				if (j == P.length()) {
					positions.add(i-j);
					j = lps[j-1];
				}
			}
			else {
				if (j > 0) {
					j = lps[j-1];
				}
				else {
					i++;
				}
			}
		}
		return positions;
	}
	
	//lps (longest prefix suffix)
	private static int[] lps(String P) {
		int n = P.length();
		int[] lps = new int[n];
		int len = 0;
		int i = 1;
		
		while (i < n) {
			if (P.charAt(i) == P.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			else {
				if (len > 0) {
					len = lps[len-1];
				}
				else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}

}
