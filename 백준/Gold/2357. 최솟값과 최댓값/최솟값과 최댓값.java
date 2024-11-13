import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] arr;
	static int[] minTree, maxTree;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = (1<<(h+1));
		minTree = new int[treeSize];
		maxTree = new int[treeSize];
		
		initMin(1,0,N-1);
		initMax(1,0,N-1);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			int minVal = queryMin(1,0,N-1,a,b);
			int maxVal = queryMax(1,0,N-1,a,b);
			
			sb.append(minVal).append(" ").append(maxVal).append("\n");
		}
		System.out.println(sb);
		
	}
	static int initMin(int node, int start, int end) {
		if (start == end) {
			return minTree[node] = arr[start];
		}
		
		int mid = (start+end)/2;
		return minTree[node] = Math.min(initMin(node*2,start,mid), initMin(node*2+1,mid+1,end));
		
	}
	static int initMax(int node, int start, int end) {
		if (start == end) {
			return maxTree[node] = arr[start];
		}
		
		int mid = (start+end)/2;
		return maxTree[node] = Math.max(initMax(node*2,start,mid), initMax(node*2+1,mid+1,end));
		
	}
	
	static int queryMin(int node, int start, int end, int left, int right) {
		if (right < start || left > end) return Integer.MAX_VALUE;
		
		if (left <= start && right >= end) {
			return minTree[node];
		}
		
		int mid = (start+end)/2;
		return Math.min(queryMin(node*2, start, mid, left, right), queryMin(node*2+1, mid+1, end, left, right));
	}
	
	static int queryMax(int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return Integer.MIN_VALUE;
		}
		
		if (left <= start && right >= end) {
			return maxTree[node];
		}
		
		int mid = (start+end)/2;
		return Math.max(queryMax(node*2, start, mid, left, right), queryMax(node*2+1, mid+1, end, left, right));
	}

}
