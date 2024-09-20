import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최솟값
 * N개의 정수들(1<=N<=100_000)이 있을때
 * a번째 정수부터 b번째 정수까지 중에서 제일 작은 정수를 찾는 것
 * 
 * @author KOREA
 *
 */
public class Main {
	static int N,M;
	static int[] arr;
	static int[] minTree;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		for (int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		minTree = new int[N*4];
		init(1,N,1);
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(minFind(1,N,1,a,b));
		}

	}
	public static int init(int start, int end, int node) {
		if (start == end) {
			return minTree[node] = arr[start];
		}
		
		int mid = (start+end)/2;
		return minTree[node] = Math.min(init(start,mid,node*2), init(mid+1, end, node*2+1));
	}
	
	public static int minFind(int start, int end, int idx, int left, int right) {
		if (right<start || end < left) return Integer.MAX_VALUE;
		
		if (left<=start && right>=end){
			return minTree[idx];
		}
		
		int mid = (start+end)/2;
		return Math.min(minFind(start,mid,idx*2,left,right), minFind(mid+1, end, idx*2+1, left,right));
	}

}