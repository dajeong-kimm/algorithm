import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] lastIndex;
	
	static int[] arr, tree;
	
	static int init(int node, int start, int end) {
		if (start == end) return tree[node] = arr[start];
		
		int mid = (start+end)/2;
		return tree[node] = Math.max(init(node*2, start, mid), init(node*2+1, mid+1, end));
	}
	
	static int getMax(int node, int start, int end, int left, int right) {
		if (left > right) return Integer.MIN_VALUE;
		
		if (left > end || right < start) return Integer.MIN_VALUE;
		
		if (left<=start && end <=right) return tree[node];
		
		int mid = (start+end)/2;
		return Math.max(getMax(node*2, start, mid, left, right), getMax(node*2+1, mid+1, end, left, right));
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			int h = (int) Math.ceil(Math.log(N) / Math.log(2));
			int treeSize = 1<<(h+1);
			
			tree = new int[treeSize];
			lastIndex = new int[N+1];
			Arrays.fill(lastIndex, -1);
			
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<N;i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i] = num;
			}
			
			init(1, 0, N-1);
			boolean flag = false;
			for (int i=0;i<N;i++) {
				int curNum = arr[i];
				if (lastIndex[curNum] == -1) {
					lastIndex[curNum] = i;
					continue;
				}
				
				int before = lastIndex[curNum];
				
				if (getMax(1, 0, N-1, before+1, i-1) > curNum) {
					sb.append("No");
					flag = true;
					break;
				}
				
				lastIndex[curNum] = i;
			}
			if (!flag) sb.append("Yes");
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

}
