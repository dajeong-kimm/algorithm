import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] arr;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = (1<<(h+1));
		tree = new int[treeSize];
		
		arr = new int[N];
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		init(1,0,N-1);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			sb.append(query(1,0,N-1,a,b)).append("\n");
		}
		System.out.println(sb);
	}
	static int query(int node, int start, int end, int left, int right) {
		if (left > end || right < start) return Integer.MAX_VALUE;
		
		if (left <= start && right >= end) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		return Math.min(query(node*2, start, mid, left, right), query(node*2+1, mid+1, end, left, right));
	}
	
	static int init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		}
		
		int mid = (start+end)/2;
		return tree[node] = Math.min(init(node*2, start, mid),init(node*2+1, mid+1, end));
	}

}
