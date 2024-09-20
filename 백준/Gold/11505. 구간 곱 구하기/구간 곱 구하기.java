import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 곱 구하기
 * 어떤 N개의 수 
 * @author KOREA
 *
 */
public class Main {
	static int N,M,K;
	static long[] arr;
	
	static long[] tree;
	
	static final int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		for (int i=1;i<=N;i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		tree = new long[N*4];
		init(1,N,1);
		
		for (int i=0;i<M+K;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			//b번째 수를 c로 바꾸기
			if (a == 1) {
				update(1,N,1,b,c);
			}
			//b부터 c까지의 곱 구하기
			else {
				System.out.println(mul(1,N,1,b,c));
			}
		}

	}
	public static long init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = arr[start];
		}
		
		int mid = (start+end)/2;
		//leat 노드가 아니면
		return tree[node] = (init(start, mid, node*2)*init(mid+1, end, node*2+1))%1_000_000_007;
	}
	
	public static long update (int start, int end, int node, int idx, long value) {
		if (start == end) {
			return tree[node] = value;
		}
		
		int mid = (start+end)/2;
		
		if (idx <= mid) {
			tree[node] = (update(start, mid, node*2, idx, value) * tree[node*2+1]) % MOD;
		}
		else {
			tree[node] = (tree[node*2] * update(mid+1, end, node*2+1, idx, value)) % MOD;
		}
		return tree[node];
		
	}
	
	public static long mul (int start, int end, int node, int left, int right) {
		if (left > end || right < start) {
			return 1;
		}
		
		if (left <= start && end <=right) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		return (mul(start, mid, node*2, left, right) * mul(mid+1, end, node*2+1, left, right))%MOD;
	}
}