import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb;
	
	static int N;
	static int[] arr;
	static boolean[] is_selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		sb = new StringBuilder();
		arr = new int[N];
		is_selected = new boolean[N+1];
		permutation(0);
		System.out.println(sb);
	}
	
	public static void permutation(int cnt) {
		
		if (cnt == N) {
			for (int i=0;i<N;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=1;i<=N;i++) {
			if (!is_selected[i]) {
				is_selected[i] = true;
				arr[cnt] = i;
				permutation(cnt+1);
				is_selected[i] = false;
			}
		}
	}

}