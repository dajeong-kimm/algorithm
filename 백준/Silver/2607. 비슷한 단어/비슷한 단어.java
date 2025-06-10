import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		String firstWord = br.readLine();
		
		for (int i=1;i<N;i++) {
			int[] first = new int[26];
			for (int j=0;j<firstWord.length();j++) {
				first[firstWord.charAt(j)-'A']++;
			}
			
			String word = br.readLine();
			int same = 0;
			for (int j=0;j<word.length();j++) {
				char ch = word.charAt(j);
				if (first[ch-'A'] > 0) {
					first[ch-'A']--;
					same++;
				} 
			}
			
			if (firstWord.length() == word.length() && (firstWord.length() == same || firstWord.length()-1 == same)) {
				answer++;
			} else if (firstWord.length()-1 == word.length() && firstWord.length()-1 == same) {
				answer++;
			} else if (firstWord.length()+1 == word.length() && firstWord.length() == same) {
				answer++;
			}
		}
		
		System.out.println(answer);

	}

}
