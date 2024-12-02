import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, tree;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 2*M-1;
		
		StringBuilder sb = new StringBuilder();
		
		tree = new int[N*4];
		init(1,1,N);
		for (int i=1;i<=N-cnt+1;i++) {
			int max = query(1, 1, N, i, i+cnt-1);
			sb.append(max).append(" ");
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
		
		tree[node] = Math.max(tree[node*2], tree[node*2+1]);
	}
	
	static void update(int node, int start, int end, int idx, int value) {
		if (start == end) {
			tree[node] = Math.max(tree[node], value);
			return;
		}
		
		int mid = (start+end)/2;
		if (idx <= mid) {
			update(node*2, start, mid, idx, value);
		}
		else {
			update(node*2+1, mid+1, end, idx, value);
		}
		tree[node] = Math.max(tree[node*2], tree[node*2+1]);
		
	}
	
	static int query(int node, int start, int end, int left, int right) {
		if (left > end || right < start) return Integer.MIN_VALUE;
		
		if (start >= left && end <= right) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		int leftQuery = query(node*2, start, mid, left, right);
		int rightQuery = query(node*2+1, mid+1, end, left, right);
		
		return Math.max(leftQuery, rightQuery);
	}

}