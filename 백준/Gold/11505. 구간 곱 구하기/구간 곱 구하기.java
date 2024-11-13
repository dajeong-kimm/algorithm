import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author KOREA
 *
 */
public class Main {
	static int N,M,K;
	static long[] arr;
	static long[] tree;
	
	static int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new long[N];
		for (int i=0;i<N;i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = (1<<(h+1));
		
		tree = new long[treeSize];
		
		init(1,0,N-1);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<M+K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == 1) {
				update(1,0,N-1,b-1,c);
			}
			else if (a == 2) {
				sb.append(query(1,0,N-1,b-1,c-1)).append("\n");
			}
		}
		System.out.println(sb);
		
	}
	static long update(int node, int start, int end, int index, long newValue) {
		if (index < start || index > end) {
			return tree[node];
		}
		if (start == end) {
			return tree[node] = newValue % MOD;
		}
		
		int mid = (start + end) /2;
		return tree[node] = (update(node*2, start, mid, index, newValue) * update(node*2+1, mid+1, end, index, newValue))%MOD;
	}
	
	static long query(int node, int start, int end, int left, int right) {
		if (right < start || left > end) {
			return 1;
		}
		
		if (left <= start && right >= end) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		return (query(node*2, start, mid, left, right)*query(node*2+1, mid+1, end, left, right))%MOD;
	}
	
	static long init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		}
		
		int mid = (start+end)/2;
		return tree[node] = (init(node*2, start, mid) * init(node*2+1, mid+1, end)) % MOD;
	}

}