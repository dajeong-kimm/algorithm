import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 길이가 M인 수열
 * 같은 수 여러번 가능
 * @author KOREA
 *
 */
public class Main {
	static int N,M;
	
	static StringBuilder sb;
	
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		
		DFS(0);
		
		System.out.println(sb.toString());

	}
	private static void DFS(int cnt) {
		if (cnt == M) {
			for (int i=0;i<M;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=1;i<=N;i++) {
			arr[cnt] = i;
			DFS(cnt+1);
		}
	}

}