import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] tree;
	static int[] position;
	static int n, m, top;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			tree = new int[4*(n+m)];
			position = new int[n+1];
			top = n;
			
			for (int i=1;i<=n;i++) {
				position[i] = (n+1-i);
				update(1, 1, n+m, i, 1);
			}
			
			
			
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<m;i++) {
				int movie = Integer.parseInt(st.nextToken());
				int curPos = position[movie];
				int cnt = query(1, 1, n+m, curPos+1, top);
				sb.append(cnt).append(" ");
				
				//현재 dvd를 가장 위로 이동
				update(1, 1, n+m, curPos, 0);
				top++;
				position[movie] = top;
				update(1, 1, n+m, top, 1);
			}
			sb.append("\n");
			
		}
		System.out.println(sb);

	}
	
	static void update(int node, int start, int end, int idx, int value) {
		if (start == end) {
			tree[node] = value;
			return;
		}
		
		int mid = (start+end) /2;
		if (idx <= mid) {
			update(node*2, start, mid, idx, value);
		}
		else {
			update(node*2+1, mid+1, end, idx, value);
		}
		
		tree[node] = tree[node*2] + tree[node*2+1];
	}
	
	static int query(int node, int start, int end, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}
		
		if (left <= start && right >= end) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		int leftQuery = query(node*2, start, mid, left, right);
		int rightQuery = query(node*2+1, mid+1, end, left, right);
		return leftQuery + rightQuery;
	}

}