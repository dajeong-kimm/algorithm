import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//짝수의 개수만 저장
public class Main {
	static int[] arr, tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		tree = new int[4*N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			int num = Integer.parseInt(st.nextToken());
			if ((num&1) == 0) arr[i] = 1;
		}
		
		init(1, 1, N);
		
		int M = Integer.parseInt(br.readLine());
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (num == 1) {
				//짝수 -> 홀수
				if (arr[a] == 1 && (b&1) != 0) {
					arr[a] = 0;
					update(1, 1, N, a, -1);
				}
				//홀수 -> 짝수
				else if (arr[a] == 0 && (b & 1) == 0) {
					arr[a] = 1;
					update(1, 1, N, a, 1);
				}
			}
			//짝수의 개수
			else if (num == 2) {
				int cnt = query(1, 1, N, a, b);
				sb.append(cnt).append("\n");
			}
			//홀수의 개수
			else {
				int cnt = query(1, 1, N, a, b);
				int oddCnt = (b - a + 1) - cnt;
				sb.append(oddCnt).append("\n");
			}
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
		
		tree[node] = tree[node*2] + tree[node*2+1];
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
		
		if (start >= left && end <= right) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		
		int leftQuery = query(node*2, start, mid, left, right);
		int rightQuery = query(node*2+1, mid+1, end, left, right);
		
		return leftQuery + rightQuery;
	}

}