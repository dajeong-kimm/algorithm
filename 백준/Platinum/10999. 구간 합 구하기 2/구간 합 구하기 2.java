import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static long[] arr;
	static long[] tree;
	static long[] lazy;

	public static void main(String[] args) throws IOException {
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
		lazy = new long[treeSize];
		
		init(1,0,N-1);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<M+K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			
			if (a == 1) {
				long d = Long.parseLong(st.nextToken());
				update(1,0,N-1,b,c,d);
			} 
			else if (a == 2) {
				sb.append(query(1,0,N-1,b,c)).append("\n");
			}
		}
		System.out.println(sb);
	}
	static void propagate(int node, int start, int end) {
		if (lazy[node] != 0) {
			//구간 크기만큼 값 추가
			tree[node] += (end-start+1) * lazy[node];
			//리프 노드가 아닌 경우 자식 노드에 lazy값 추가
			if (start != end) {
				lazy[node*2] += lazy[node];
				lazy[node*2+1] += lazy[node];
			}
			lazy[node] = 0;		}
	}
	
	static void update(int node, int start, int end, int left, int right, long diff) {
		propagate(node, start, end);
		
		if (right < start || left > end) return;
		
		if (left <= start && end <= right) {
			tree[node] += (end-start+1)*diff;
			if (start != end) {
				lazy[node*2] += diff;
				lazy[node*2+1] += diff;
			}
			return;
		}
		
		//현재 노드가 업데이트 구간에 부분적으로 걸쳐있는 경우
		int mid = (start+end)/2;
		update(node*2, start, mid, left, right, diff);
		update(node*2+1, mid+1, end, left, right, diff);
		tree[node] = tree[node*2] + tree[node*2+1];
	}
	
	static long query(int node, int start, int end, int left, int right ) {
		propagate(node, start, end);
		
		if (right < start || end < left) {
			return 0;
		}
		
		if (left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		return query(node*2, start, mid, left, right) + query(node*2+1,mid+1, end, left, right );
	}
	
	static long init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		}
		
		int mid = (start+end)/2;
		return tree[node] = init(node*2, start, mid) + init(node*2+1, mid+1, end);
	}

}