import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	static int tree[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] sorted = new int[N];
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sorted[i] = arr[i];
		}
		
		Arrays.sort(sorted);
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i=0;i<N;i++) {
			map.put(sorted[i], i+1);
		}
		
		tree = new int[4*N];
		StringBuilder sb = new StringBuilder();
		
		for (int i=0;i<N;i++) {
			//rank 클수록 높은 점수
			int rank = map.get(arr[i]);
			
			//더 낮은 실력의 수
			int cnt = query(1, 1, N, 1, rank-1);
			int answer = (i+1) - cnt;
			sb.append(answer).append("\n");
			
			update(1, 1, N, rank, 1);
		}
		
		System.out.println(sb);
	}
	
	static void update(int node, int start, int end, int idx, int value) {
		if (start == end) {
			tree[node] += value;
			return;
		}
		
		int mid = (start + end) / 2;
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
		
		if (start>=left && end <=right) {
			return tree[node];
		}
		
		int mid = (start+end) /2;
		int leftResult = query(node*2, start, mid, left, right);
		int rightResult = query(node*2+1, mid+1, end, left, right);
		
		return leftResult + rightResult;
	}

}
