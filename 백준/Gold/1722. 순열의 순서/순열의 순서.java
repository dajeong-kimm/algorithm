import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * k가 주어지면 k번째 순열을 구하고,
 * 임의의 순열이 주어지면 이 순열이 몇번째인지 출력해야 함
 * @author KOREA
 *
 */
public class Main {
	static int N;
	
	static long[] fac = new long[21];

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		fac[0] = 1;
		for (int i=1;i<=20;i++) {
			fac[i] = i*fac[i-1];
		}
		
		int num = Integer.parseInt(st.nextToken());
		
		long k = 0;
		
		int[] arr = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		Vector<Integer> ans = new Vector<Integer>();
		
		long answer = 1;
		
		if (num == 1) {
			k = Long.parseLong(st.nextToken());
			for (int i=0;i<N;i++) {
				for (int j=1;j<=N;j++) {
					if (!visited[j]) {
						if (k - fac[N-1-i] > 0) {
							k -= fac[N-1-i];
						}
						else {
							ans.add(j);
							visited[j] = true;
							break;
						}
					}
				}
			}
			
			for (int i=0;i<ans.size();i++) {
				System.out.print(ans.elementAt(i)+" ");
			}
		}
		else if (num == 2) {
			for (int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i=0;i<N;i++) {
				for (int j=1;j<arr[i];j++) {
					if (!visited[j]) {
						answer += fac[N-1-i];
					}
				}
				visited[arr[i]] = true;
			}
			
			System.out.println(answer);
		}
		
	}


}