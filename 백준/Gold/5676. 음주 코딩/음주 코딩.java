import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, tree;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		String input;
		
		while ((input = br.readLine()) != "" && input != null) {
			st = new StringTokenizer(input);
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			arr = new int[N+1];
			tree = new int[4*N];
			
			st = new StringTokenizer(br.readLine());
			for (int i=1;i<=N;i++) {
				int value = Integer.parseInt(st.nextToken());
				arr[i] = sign(value);
			}
			
			init(1,1,N);
			
			for (int k=0;k<K;k++) {
				st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				
				//변경
				if (command.equals("C")) {
					int i = Integer.parseInt(st.nextToken());
					int v = Integer.parseInt(st.nextToken());
					update(1, 1, N, i, sign(v));
				}
				//구간곱
				else {
					int i = Integer.parseInt(st.nextToken());
					int j = Integer.parseInt(st.nextToken());
					int result = query(1, 1, N, i, j);
					
					if (result == 0) sb.append("0");
					else if (result > 0) sb.append("+");
					else sb.append("-");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		

	}
	
	static int sign(int value) {
		if (value > 0) return 1;
		if (value < 0) return -1;
		return 0;
	}
	
	static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
			return;
		}
		
		int mid = (start+end)/2;
		init(node*2, start, mid);
		init(node*2+1, mid+1, end);
		tree[node] = tree[node*2] * tree[node*2 + 1];
		
	}
	
	static void update(int node, int start, int end, int idx, int value) {
		if (start == end) {
			tree[node] = value;
			arr[idx] = value;
			return;
		}
		
		int mid = (start+end)/2;
		
		if (idx <= mid) {
			update(node*2, start, mid, idx, value);
		}
		else {
			update(node*2+1, mid+1, end, idx, value);
		}
		
		tree[node] = tree[node*2] * tree[node*2+1];
	}
	
	static int query(int node, int start, int end, int left, int right) {
		if (left > end || right < start) return 1;
		
		if (left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start+end) /2;
		int leftQuery = query(node*2, start, mid, left, right);
		int rightQuery = query(node*2+1, mid+1, end, left, right);
		
		return leftQuery * rightQuery;
	}

}