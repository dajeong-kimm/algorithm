import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] tree, lazy;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		tree = new int[N*4];
		lazy = new int[N*4];
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int comm = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			//반전
			if (comm == 0) {
				update(1, 1, N, from, to);
			}
			//켜진 스위치 개수
			else {
				int result = query(1, 1, N, from, to);
				sb.append(result).append("\n");
			}
			
		}
		System.out.println(sb);
	}
	static void propagate(int node, int start, int end) {
		if (lazy[node] != 0) {
			tree[node] = (end - start + 1) - tree[node];
			
			if (start != end) {
				lazy[node*2] ^= 1;
				lazy[node*2+1] ^= 1;
			}
			
			lazy[node] = 0;
		}
	}
	
	static void update(int node, int start, int end, int left, int right) {
		propagate(node, start, end);
		
		if (right < start || left > end) return;
		
		if (left <= start && end <= right) {
			lazy[node] ^= 1;
			propagate(node, start, end);
			return;
		}
		
		int mid = (start+end)/2;
		update(node*2, start, mid, left, right);
		update(node*2+1, mid+1, end, left, right);
		tree[node] = tree[node*2] + tree[node*2+1];
	}
	
	static int query(int node, int start, int end, int left, int right) {
		propagate(node, start, end);
		
		if (right < start || left > end) return 0;
		
		if (left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		int leftQuery = query(node*2, start, mid, left, right);
		int rightQuery = query(node*2+1, mid+1, end, left, right);
		return leftQuery + rightQuery;
	}

}