import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 최솟값과 최댓값
 * 1<=N<=100_000개의 정수들
 * 
 * 자료구조, 세그먼트 트리
 * 
 * minInit, maxInit -> 트리 2개
 * @author KOREA
 *
 */
public class Main {
	static int N,M;
	static int[] arr;
	static int[] minTree, maxTree;
	
	public static int minInit(int start, int end, int node) {
		if (start == end) {
			return minTree[node] = arr[start];
		}
		int mid = (start+end)/2;
		return minTree[node] = Math.min(minInit(start,mid,node*2),minInit(mid+1,end,node*2+1));
	}
	
	public static int maxInit(int start, int end, int node) {
		if (start == end) {
			return maxTree[node] = arr[start];
		}
		
		int mid = (start+end)/2;
		return maxTree[node] = Math.max(maxInit(start,mid,node*2), maxInit(mid+1,end,node*2+1));
	}
	
	//left ~ right 범위 내의 최솟값 찾기
	public static int minFind(int start, int end, int node, int left, int right) {
		if (right < start || end < left) {
			return Integer.MAX_VALUE;
		}
		
		if (left<=start && end<=right) {
			return minTree[node];
		}
		
		int mid = (start+end)/2;
		return Math.min(minFind(start,mid,node*2,left,right), minFind(mid+1,end,node*2+1,left,right));
	}
	
	//left ~ right 범위 내의 최댓값 찾기
	public static int maxFind(int start, int end, int node, int left, int right) {
		if (right < start || end < left) {
			return Integer.MIN_VALUE;
		}
		
		if (left<=start && end<=right) {
			return maxTree[node];
		}
		
		int mid = (start+end)/2;
		
		return Math.max(maxFind(start,mid,node*2,left,right), maxFind(mid+1,end,node*2+1,left,right));
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		for (int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		minTree = new int[N*4];
		maxTree = new int[N*4];
		
		minInit(1,N,1);
		maxInit(1,N,1);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			sb.append(minFind(1,N,1,left,right)+" "+maxFind(1,N,1,left,right)+"\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		

	}

}