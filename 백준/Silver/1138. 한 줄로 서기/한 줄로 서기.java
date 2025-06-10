import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] front = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			front[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] answer = new int[N];
		
		for (int i=0;i<N;i++) {
			int cnt = 0;
			for (int j=0;j<N;j++) {
				
				if (answer[j] == 0) {
					if (cnt == front[i]) {
						answer[j] = (i+1);
						break;
					}
					cnt++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<N;i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}

}
