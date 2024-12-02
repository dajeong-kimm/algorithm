import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int[] tree, arr;
	static int node = 65536;
	
	static long answer;
	
	static int N,K;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		for (int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		tree = new int[node*4];
		
		//처음 K개 추가
		for (int i=1;i<=K;i++) {
			update(1, 0, node, arr[i], 1);
		}
		answer = getMid();
		for (int i=K+1;i<=N;i++) {
			update(1, 0, node, arr[i], 1);
			update(1, 0, node, arr[i-K], -1);
			answer += getMid();
		}
		System.out.println(answer);
		
	}
	static int getMid() {
		int result=0;
		
		int start = 0;
		int end = node;
		while (start <= end) {
			int mid = (start+end)/2;
			
			if (query(1, 0, node, mid, node) >= (K/2+1)) {
				result = mid;
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		return result;
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
	
	static int query(int node, int start, int end, int left, int right) {
		if (left > end || right < start) return 0;
		
		if (left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		int leftQuery = query(node*2, start, mid, left, right);
		int rightQuery = query(node*2+1, mid+1, end, left, right);
		return leftQuery + rightQuery;
	}

}