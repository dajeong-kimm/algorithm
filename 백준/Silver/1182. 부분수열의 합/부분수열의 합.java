import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,S;
	static int[] arr;
	
	static int answer;
	
	static int[] tmp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		answer = 0;
//		Arrays.sort(arr);
		
		dfs(0,0);
		if (S == 0) answer--;
		System.out.println(answer);
	}
	
	public static void dfs(int idx, int cur_num) {
		if (idx == N) {
			if (cur_num == S) answer++;
			return;
		}
		
		dfs(idx+1, cur_num);
		dfs(idx+1, cur_num + arr[idx]);
	}
	
	

}