import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static long[] arr;
	static long[] tree;
	
	//초기화
	static long init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		}
		else {
			int mid = (start+end)/2;
			return tree[node] = init(node*2, start, mid) + init(node*2+1,mid+1,end);
		}
	}
	
	//업데이트
	static void update(int node, int start, int end, int index, long diff) {
		if (index < start || index > end) return;
		
		tree[node] += diff;
		if (start != end) {
			int mid = (start+end)/2;
			update(node*2, start, mid, index, diff);
			update(node*2+1, mid+1, end, index, diff);
		}
	}
	
	//구간합쿼리
	static long sum (int node, int start, int end, int left, int right) {
		if (left > end || right < start) return 0;
		
		if (left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		return sum(node*2,start,mid,left,right) + sum(node*2+1,mid+1,end,left,right);
	}

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
		
		//세그먼트 트리 크기 설정
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = (1<<(h+1));
		tree = new long[treeSize];
		
		init(1,0,N-1);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<M+K;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken())-1;
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) {
				long diff = c - arr[b];
				arr[b] = c;
				update(1,0,N-1,b,diff);
			}
			else if (a == 2) {
				sb.append(sum(1,0,N-1,b,(int)c -1)).append("\n");
			}
		}
		System.out.println(sb);
		

	}

}