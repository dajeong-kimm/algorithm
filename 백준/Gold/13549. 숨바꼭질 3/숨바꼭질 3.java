import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 숨바꼭질 3
 * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지?
 * @author SSAFY
 *
 */
public class Main {
	static int[] visited;
	static int N,K;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new int[100001];
		Arrays.fill(visited, Integer.MAX_VALUE);
		
		if (N==0) {
			if (K==0) {
				System.out.println(0);
			} else {
				System.out.println(bfs()+1);
			}
		}else {
			System.out.println(bfs());
		}
		
		
	}
	public static int bfs() {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		if (N==0) {
			queue.add(1);
			visited[0] = 0;
			visited[1] = 0;
		}
		else {
			queue.add(N);
			visited[N] = 0;
		}
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if (cur == K) return visited[cur];
			
			if (cur*2<=100000 && visited[cur*2]==Integer.MAX_VALUE) {
				visited[cur*2] = visited[cur];
				queue.addFirst(cur*2);
			}
			
			if (cur-1>=0 && visited[cur-1]==Integer.MAX_VALUE) {
				visited[cur-1] = visited[cur]+1;
				queue.add(cur-1);
			}
			
			if (cur+1<=100000 && visited[cur+1]==Integer.MAX_VALUE) {
				visited[cur+1] = visited[cur]+1;
				queue.add(cur+1);
			}
			
		}
		
		return -1;
	}

}