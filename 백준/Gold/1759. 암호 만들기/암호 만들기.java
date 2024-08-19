import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 서로 다른 L개의 알파벳 소문자
 * 최소 한 개의 모음 (a,e,i,o,u) + 최소 두개의 자음
 * 알파벳이 증가하는 순서로 배열 
 * 
 * C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램
 * @author KOREA
 *
 */
public class Main {
	static int L,C;
	static char[] input;
	
	static char[] word;
	
	static HashSet<Character> set = new HashSet<>();
	
	static StringBuilder sb;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		input = new char[C];
		word = new char[L];
		for (int i=0;i<C;i++) {
			input[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(input);
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		
		Combination(0,0);
		
		System.out.println(sb);
//		System.out.println(Arrays.toString(input));
	}
	private static void Combination(int cnt, int start) {
		if (cnt == L) {
//			Arrays.sort(word);
			int[] cur = counting();
			if (cur[0]>=1 && cur[1]>=2) {
				for (int i=0;i<L;i++) {
					sb.append(word[i]);
				}
				sb.append("\n");
			}
			return;
		}
		for (int i=start;i<C;i++) {
			word[cnt] = input[i];
			Combination(cnt+1, i+1);
		}
	}
	
	private static int[] counting() {
		int a = 0; //모음
		int b = 0; //자음
		
		for (int i=0;i<L;i++) {
			if (set.contains(word[i])) a++;
			else b++;
		}
		return new int[] {a,b};
		
	}

}