import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		tree = new long[4*N];
		for (int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			//추가
			if (num == 1) {
				int p = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				update(1, 1, N, p, x);
			}
			//쿼리
			else {
				int p = Integer.parseInt(st.nextToken());
				int q = Integer.parseInt(st.nextToken());
				
				long result = query(1, 1, N, p, q);
				sb.append(result).append("\n");
			}
		}
		
		System.out.println(sb);

	}
	
	static void update(int node, int start, int end, int idx, int value) {
		if (start == end) {
			tree[node] += value;
			return;
		}
		
		int mid = (start+end)/2;
		if (idx <= mid) {
			update(node*2, start, mid, idx, value);
		}
		else {
			update(node*2+1, mid+1, end, idx, value);
		}
		
		tree[node] = tree[node*2] + tree[node*2+1];
		
		
	}
	
	static long query(int node, int start, int end, int left, int right) {
		if (left > end || right < start) return 0;
		
		if (left<=start && right>=end) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		long leftQuery = query(node*2, start, mid, left, right);
		long rightQuery = query(node*2+1, mid+1, end, left, right);
		return leftQuery + rightQuery;
	}

}