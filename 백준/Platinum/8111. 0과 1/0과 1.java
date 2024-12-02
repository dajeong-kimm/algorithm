import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static class Node {
		String number;
		int remainder;
		
		Node(String number, int remainder){
			this.number = number;
			this.remainder = remainder;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(findNum(N)).append("\n");
		}
		System.out.println(sb);
	}
	
	static String findNum(int N) {
		if (N == 1) return "1";
		
		Queue<Node> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		
		queue.add(new Node("1", 1%N));
		visited[1%N] = true;
		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if (cur.remainder == 0) {
				return cur.number;
			}
			
			for (int digit =0 ; digit <= 1; digit++) {
				int next = (cur.remainder*10 + digit) % N;
				
				if (!visited[next]) {
					visited[next] = true;
					queue.add(new Node(cur.number + digit, next));
				}
			}
		}
		
		return "BRAK";
	}

}