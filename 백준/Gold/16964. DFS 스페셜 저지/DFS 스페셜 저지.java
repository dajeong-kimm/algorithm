import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * DFS 스페셜 저지
 * @author KOREA
 *
 */
public class Main {
	static int N;
	static Stack<Integer> stack = new Stack<>();
	static int[] order;
	static int answer = 1;
	
	static HashSet<Integer> graph[];
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		graph = new HashSet[N+1];
		for (int i=0;i<=N;i++) {
			graph[i] = new HashSet<>();
		}
		
		for (int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		st = new StringTokenizer(br.readLine());
		order = new int[N];
		for (int i=0;i<N;i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		visited = new boolean[N+1];
		visited[1] = true;
		stack.add(1);
		for (int i=1;i<N;i++) {
			A: while (true) {
				int next = order[i];
				if (stack.size() == 0) {
					System.out.println(0);
					return;
				}
				int peek = stack.peek();
				boolean isAvail = false;
				if (graph[peek].contains(next)) {
					stack.add(next);
					visited[next] = true;
					isAvail = true;
					break A;
					
				}
				if (!isAvail) {
					if (stack.size() == 0) {
						System.out.println(0);
						return;
					}
					else stack.pop();
				}
			}
			
		}
		System.out.println(1);
		
		
	}
	
	

}