import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		//depth당 1초
		int answer = 0;
		Queue<Integer> q = new ArrayDeque<>();
		Set<Integer> visited = new HashSet<>();
		q.add(N);
		visited.add(N);
		
		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i=0;i<qSize;i++) {
				int cur = q.poll();
//				System.out.println("cur: "+cur+" answer: "+answer);
				
				if (cur == K) {
					System.out.println(answer);
					return;
				}
				
				if (cur == 0) {
					if (!visited.contains(1)) {
						q.add(1);
						visited.add(1);
					}
				} else if (cur == 100_000) {
					if (!visited.contains(99_999)) {
						q.add(99_999);
						visited.add(99_999);
					}
				} else {
					// *2
					if (!visited.contains(cur*2) && (cur*2 <= 100_000)) {
						q.add(cur*2);
						visited.add(cur*2);
					}
					
					// +1
					if (!visited.contains(cur+1)) {
						q.add(cur+1);
						visited.add(cur+1);
					}
					
					// -1
					if (!visited.contains(cur-1)) {
						q.add(cur-1);
						visited.add(cur-1);
					}
				}
			}
			answer++;
			
		}
		
	}

}
