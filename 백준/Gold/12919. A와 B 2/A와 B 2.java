import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A와 B 2
 * A와 B로만 이루어진 영어단어가 존재
 * 1. 문자열 뒤에 A를 추가
 * 2. 문자열 뒤에 B를 추가하고 뒤집기
 * @author SSAFY
 *
 */
public class Main {
	static String S,T;
	static int answer=0;
	static int Acnt;
	static int Bcnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		T = br.readLine();
		
		for (int i=0;i<T.length();i++) {
			if (T.charAt(i) == 'A') Acnt++;
			else Bcnt++;
		}
		
//		String reverseS = new StringBuilder(S).reverse().toString();
		int A=0;
		int B=0;
		for (int i=0;i<S.length();i++) {
			if (S.charAt(i) == 'A') A++;
			else B++;
		}
		makeS(T);
		System.out.println(answer);
	
	}
	public static void makeS(String T) {
		if (T.length() == S.length()) {
			if (T.equals(S)) {
				answer = 1;
			}
			return;
		}
		
		int len = T.length();
		if (T.charAt(len-1) == 'A') {
			String newT = T.substring(0,len-1);
			makeS(newT);
		}
		
		String reverseT = new StringBuilder(T).reverse().toString();
		if (reverseT.charAt(len-1) == 'B') {
			String newT = reverseT.substring(0, len-1);
			makeS(newT);
		}
	}

}