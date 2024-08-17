import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 학생들이 되도록 많은 단어를 읽을 수 있도록
 * 
 * K개의 글자로만 이루어진 단어
 * 
 * 어떤K개의 글자를 가르쳐야 학생들이 읽을 수 있는 단어의 개수가 최대가 되는지?
 * "anta"로 시작 --> "tica"로 끝남
 * 
 * 남극언어에 단어는 총 N개
 * 
 * 학생들이 읽을 수 있는 단어의 최댓값 구하기
 * @author KOREA
 *
 */
public class Main {
	static int N,K;
	
	static String[] arr;
	
	static int[] words; //각 단어를 비트마스크로 표현한 배열
	
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		words = new int[N];
		
		//기본적으로 배워야할 문자 a c i n t를 비트마스크로 표현
		int learn = 0;
		learn |= (1<<('a'-'a'));
		learn |= (1<<('c'-'a'));
		learn |= (1<<('i'-'a'));
		learn |= (1<<('n'-'a'));
		learn |= (1<<('t'-'a'));
		
		for (int i=0;i<N;i++) {
			String word = br.readLine();
			int bitMask = 0;
			
			for (char c : word.toCharArray()) {
				//해당 문자를 비트마스크로 변환
				bitMask |= (1<<(c-'a')); 
			}
			words[i] = bitMask;
		}
		
		if (K<5) {
			System.out.println(0);
		} else {
			dfs (learn, 0, 0);
			System.out.println(answer);
		}
		
		
	}
	
	static void dfs(int learn, int idx, int cnt) {
		if (cnt == K-5) {
			int readCount = 0;
			for (int word : words) {
				if ((word & learn) == word) {
					readCount++;
				}
			}
			answer = Math.max(answer, readCount);
			return;
		}
		
		for (int i=idx;i<26;i++) {
			// 아직 배우지 않은 문자라면
			if ((learn & (1<<i)) == 0) {
				learn |= (1<<i);
				dfs(learn, i+1, cnt+1);
				learn &= ~(1<<i); //배운 문자 되돌리기
			}
		}
	}

}