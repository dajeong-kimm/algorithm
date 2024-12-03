import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	
	static class Node implements Comparable<Node>{
		int a, b;
		
		Node (int a, int b){
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(a, o.a);
		}
	}
	
	static Node[] wires;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		wires = new Node[N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			wires[i] = new Node(a,b);
		}
		
		Arrays.sort(wires);
		
		int[] bPos = new int[N];
		for (int i=0;i<N;i++) {
			bPos[i] = wires[i].b;
		}
		
		List<Integer> lis = new ArrayList<>();
		int[] lisIndex = new int[N];
		
		for (int i=0;i<N;i++) {
			int b = bPos[i];
			int pos = Collections.binarySearch(lis, b);
			
			if (pos <0) pos = -(pos+1);
			
			if (pos == lis.size()) {
				lis.add(b);
			}
			else {
				lis.set(pos, b);
			}
			lisIndex[i] = pos;
		}
		
		int len = lis.size();
		boolean[] isLis = new boolean[N];
		int cur = len -1;
		for (int i=N-1; i>=0 ;i--) {
			if (lisIndex[i] == cur) {
				isLis[i] = true;
				cur--;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(N - len).append("\n");
		for (int i=0;i<N;i++) {
			if (!isLis[i]) {
				sb.append(wires[i].a).append("\n");
			}
		}
		System.out.println(sb);
	}

}
