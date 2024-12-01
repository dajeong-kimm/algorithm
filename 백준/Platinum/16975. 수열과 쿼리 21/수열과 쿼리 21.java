import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] arr, tree, lazy;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		arr = new long[N+1];
		tree = new long[N * 4];
		lazy = new long[N*4];
		for (int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		init(1, 1, N);
		
		int M = Integer.parseInt(br.readLine());
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int comm = Integer.parseInt(st.nextToken());
			
			if (comm == 1) {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				long value = Long.parseLong(st.nextToken());
				
				update(1, 1, N, left, right, value);
			}
			else {
				int idx = Integer.parseInt(st.nextToken());
				long result = query(1, 1, N, idx, idx);
				sb.append(result).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static void init(int node, int start, int end) {
		if (start == end) {
			tree[node] = arr[start];
			return;
		}
		
		int mid = (start+end)/2;
		init(node*2, start, mid);
		init(node*2+1, mid+1, end);
		tree[node] = tree[node*2] + tree[node*2+1];
		
	}
	
	static void propagate(int node, int start, int end) {
		if (lazy[node] != 0) {
			//구간의 길이만큼 추가
			tree[node] += lazy[node] * (end - start + 1);
			
			//리프 노드가 아니면 자식들에게 전달
			if (start != end) {
				lazy[node*2] += lazy[node];
				lazy[node*2 + 1] += lazy[node];
			}
			
			lazy[node] = 0;
		}
	}
	
	static void update(int node, int start, int end, int left, int right, long value) {
		propagate(node, start, end);
		
		if (right < start || left > end) return;
		
		if (left <= start && end <= right) {
			lazy[node] += value;
			propagate(node, start, end);
			return;
		}
		
		int mid = (start + end ) /2;
		update(node*2, start, mid, left, right, value);
		update(node*2+1, mid+1, end, left, right, value);
		tree[node] = tree[node*2] + tree[node*2+1];
	}
	
	static long query(int node, int start, int end, int left, int right) {
		propagate(node, start, end);
		
		if (right < start || left > end) return 0;
		
		if (left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start + end) /2;
		long leftQuery = query(node*2 , start, mid, left, right);
		long rightQuery = query(node*2+1, mid+1, end, left, right);
		return leftQuery + rightQuery;
	}

}
