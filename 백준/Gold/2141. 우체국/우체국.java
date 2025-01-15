import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Node[] node;
	static long total = 0;
	static long position;
	
	static class Node implements Comparable<Node>{
		int X, A;
		
		Node(int X, int A) {
			this.X = X;
			this.A = A;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(X,  o.X);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		node = new Node[N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			node[i] = new Node(x, a);
			total += a;
		}
		
		Arrays.sort(node);
		
//		if (total == 0) {
//			System.out.println(node[0].X);
//			return;
//		}
		
		position = (total+1)/2;
//		System.out.println("position: "+position);
		long cur = 0;
		for (int i=0;i<N;i++) {
			Node curNode = node[i];
			cur += curNode.A;
			if (cur >= position) {
				System.out.println(curNode.X);
				return;
			}
		}

	}

}