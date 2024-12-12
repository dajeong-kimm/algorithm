import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] dict;
	static int answer = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		//각 단어 -> int로 변환
		dict = new int[N];
		for (int i=0;i<N;i++) {
			String input = br.readLine();
			dict[i] = bitmasking(input);
		}
		
		
//		System.out.println(Arrays.toString(dict));
		dfs(0, 0);
		System.out.println(answer);
	}
	
	static void dfs(int cnt, int visited) {
//		System.out.println(Integer.toBinaryString(visited));
		
		if (cnt == N) {
			if (visited == (1<<26)-1) {
				answer++;
			}
			return;
		}
		
		 dfs(cnt+1, visited);
		 dfs(cnt+1, visited | dict[cnt]);
	}
	
	static int bitmasking(String word) {
		int result = 0;
		
		for (int i=0;i<word.length();i++) {
			int w = word.charAt(i) - 'a';
			
			result |= (1<<w);
		}
		
		return result;
	}

}