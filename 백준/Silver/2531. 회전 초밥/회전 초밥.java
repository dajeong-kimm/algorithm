import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N*2];
		for (int i=0;i<N;i++) {
			arr[i] = arr[i+N] = Integer.parseInt(br.readLine());
		}
		
		int answer = 0;
		int[] count = new int[d+1];
		int cnt = 0;
		for (int i=0;i<k;i++) {
			if (count[arr[i]] == 0) cnt++;
			count[arr[i]]++;
		}
		
		if (count[c] == 0) answer = cnt+1;
		else answer = cnt;
		
		for (int i=1;i<N;i++) {
			if (count[arr[i-1]] == 1) cnt--;
			count[arr[i-1]]--;
			
			if (count[arr[i+k-1]] == 0) cnt++;
			count[arr[i+k-1]]++;
			
			if (count[c] == 0) answer = Math.max(answer, cnt+1);
			else answer = Math.max(answer, cnt);
			
			if (answer == k+1) break;
		}
		System.out.println(answer);
	}

}
